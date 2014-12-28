package cn.zyc.currency.producerconsumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private BlockingQueue<Resource> queue;
	private static final int SLEEPTIME = 1000;
	private boolean isRunning = true;

	public void stop() {
		isRunning = false;
	}

	public Consumer(BlockingQueue<Resource> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println("start consumer with id: "
				+ Thread.currentThread().getId());
		Random random = new Random();
		try {
			while (isRunning) {
				Resource resource = queue.take();
				if (null != resource) {
					int data = resource.getData();
					String re = MessageFormat.format("{0}*{1}={2}", data, data,
							data * data);
					System.out.println(re);
				}
				Thread.sleep(random.nextInt(SLEEPTIME));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
