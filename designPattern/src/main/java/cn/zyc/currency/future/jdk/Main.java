package cn.zyc.currency.future.jdk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		RealData real = new RealData("food");
		ExecutorService execute = Executors.newFixedThreadPool(3);
		Future<String> future = execute.submit(real);
		try {
			System.out.println("执行完成");
			String result = (String) future.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		if (future.isDone()) {
			execute.shutdown();
		}
/*		RealData real = new RealData("food");
		FutureTask<String> task = new FutureTask<>(real);
		ExecutorService execute = Executors.newFixedThreadPool(3);
		execute.submit(task);
		try {
			System.out.println("执行完成");
			String result = (String) task.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		if (task.isDone()) {
			execute.shutdown();
		}
*/
	}
}
