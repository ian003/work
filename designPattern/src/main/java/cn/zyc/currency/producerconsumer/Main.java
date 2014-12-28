package cn.zyc.currency.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<Resource> queue = new LinkedBlockingQueue<>(10);
		Producer p1 = new Producer(queue);
		Producer p2 = new Producer(queue);
		Producer p3 = new Producer(queue);
		Consumer c1 = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		Consumer c3 = new Consumer(queue);

		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(p1);
		service.execute(p2);
		service.execute(p3);
		service.execute(c1);
		service.execute(c2);
		service.execute(c3);

		try {
			TimeUnit.SECONDS.sleep(3);
			p1.stop();
			p2.stop();
			p3.stop();
			TimeUnit.SECONDS.sleep(3);
			c1.stop();
			c2.stop();
			c3.stop();
			TimeUnit.SECONDS.sleep(3);
			service.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
