package com.capitalone.sage.batch.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.listener.ItemListenerSupport;

import com.capitalone.sage.batch.processor.BANProcessor;

public class StepListener extends ItemListenerSupport implements StepExecutionListener {

	private static final Logger logger = LoggerFactory.getLogger(StepListener.class);

	// @Override
	public void beforeStep(StepExecution stepExecution) {

	}

	// @Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		logger.info("***********************************");
		logger.info("Records Read Count: {}", BANProcessor.readCount);
		logger.info("Records Processed Count: {}", BANProcessor.processedCount);
		logger.info("Total commit Count: {}", stepExecution.getCommitCount());
		logger.info("***********************************");

		return stepExecution.getExitStatus();
	}

	@Override
	public void onReadError(Exception ex) {
		logger.error("Error while fetching from file!", ex);
		super.onReadError(ex);
	}

	@Override
	public void onWriteError(Exception ex, List item) {
		logger.error("Error while processing record", ex);
		super.onWriteError(ex, item);
	}
}
