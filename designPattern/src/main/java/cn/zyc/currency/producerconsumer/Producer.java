package cn.zyc.currency.producerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

	private BlockingQueue<Resource> queue;
	private boolean isRunning = true;
	private static AtomicInteger count = new AtomicInteger();
	private static final int SLEEPTIME = 1000;

	public Producer(BlockingQueue<Resource> queue) {
		this.queue = queue;
	}

	public void stop() {
		isRunning = false;
	}

	@Override
	public void run() {

		System.out.println("start product with id: "
				+ Thread.currentThread().getId());

		Random random = new Random();

		try {
			Thread.sleep(random.nextInt(SLEEPTIME));
			Resource resource = new Resource(count.incrementAndGet());
			while (isRunning) {
				boolean finish = queue.offer(resource, 2, TimeUnit.SECONDS);
				if (!finish) {
					System.err.println("failed to put data: " + resource);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}
