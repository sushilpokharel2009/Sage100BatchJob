package com.capitalone.sage.batch.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.springframework.batch.item.ItemReader;

public class InMemoryQueueReader<ReconDTO> implements ItemReader<List<ReconDTO>> {

	private BlockingQueue<ReconDTO> queue;
	private int timeoutSeconds = DEFAULT_TIMEOUT;
	private static final int DEFAULT_TIMEOUT = 10;
	int maxCount;

	public List<ReconDTO> read() throws InterruptedException {
		int counter = 0;
		List<ReconDTO> items = null;

		while (counter < maxCount) {
			ReconDTO reconDTO = queue.poll(timeoutSeconds, TimeUnit.SECONDS);
			if (reconDTO == null) {
				return items;
			}

			if (items == null) {
				items = new ArrayList<>();
			}
			items.add(reconDTO);
			counter++;
		}
		return items;
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

	// public int getTimeoutSeconds() {
	// return timeoutSeconds;
	// }

	public void setTimeoutSeconds(int timeoutSeconds) {
		this.timeoutSeconds = timeoutSeconds;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	// public static int getDefaultTimeout() {
	// return DEFAULT_TIMEOUT;
	// }
}
