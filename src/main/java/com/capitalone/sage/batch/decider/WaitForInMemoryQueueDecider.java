package com.capitalone.sage.batch.decider;

import java.util.concurrent.BlockingQueue;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.beans.factory.annotation.Required;

public class WaitForInMemoryQueueDecider implements JobExecutionDecider {

	private BlockingQueue queue;

	private int waitTimeOut = DEFAULT_TIMEOUT;
	private static final int DEFAULT_TIMEOUT = 300;

	@Override
	public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
		try {
			int waitCounter = 0;

			while (queue.size() == 0) {
				Thread.sleep(1000);

				if (++waitCounter > waitTimeOut) {
					break;
				}
				return new FlowExecutionStatus("CONTINUE");
			}

		} catch (Exception e) {
			return new FlowExecutionStatus("ABORT");
		}

		return new FlowExecutionStatus("CONTINUE");
	}

	@Required
	public BlockingQueue getQueue() {
		return queue;
	}

	public void setQueue(BlockingQueue queue) {
		this.queue = queue;
	}

	public int getWaitTimeOut() {
		return waitTimeOut;
	}

	public void setWaitTimeOut(int waitTimeOut) {
		this.waitTimeOut = waitTimeOut;
	}

}
