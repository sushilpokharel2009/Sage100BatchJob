package com.capitalone.sage.batch.writer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;

public class InMemoryQueueWriter<ReconDTO> implements ItemWriter<ReconDTO> {

	private BlockingQueue<ReconDTO> queue;
	private int writeTimeThresholdMillis = DEFAULT_WRITE_THRESHOLD_MILLIS;
	private static final int DEFAULT_WRITE_THRESHOLD_MILLIS = 30000;
	// int maxCount;

	public void write(List<? extends ReconDTO> items) throws Exception {

		for (ReconDTO dto : items) {
			queue.put(dto);
		}
	}

	// public void setQueue(BlockingQueue<ReconDTO> accountQueue) {
	// this.queue = accountQueue;
	// }

	// public BlockingQueue<ReconDTO> getQueue() {
	// return queue;
	// }

	public void setQueue(BlockingQueue<ReconDTO> accountsQueue) {
		this.queue = accountsQueue;
	}

}
