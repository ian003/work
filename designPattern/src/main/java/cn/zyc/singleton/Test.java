package cn.zyc.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) throws Exception {
		// Singleton singleton = Singleton.getInstance();
		// Singleton.createString();
		// LazySingleton.createString();
		
		//StaticSingleton singleton = StaticSingleton.getInstance();
		StaticSingleton.createString();
		Run run = new Run();
		
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		executor.execute(run);
		executor.shutdown();
		
		SerSingleton serSingleton = SerSingleton.getInstance();
		SerSingleton serSingleton2 = null;
		
		FileOutputStream fileOutputStream = new FileOutputStream("src/ser.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(serSingleton);
		objectOutputStream.flush();
		objectOutputStream.close();
		
		
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/ser.txt"));
		serSingleton2 = (SerSingleton) objectInputStream.readObject();
		objectInputStream.close();
		
		System.out.println(serSingleton);
		System.out.println(serSingleton2);

	}

	static class Run implements Runnable {

		@Override
		public void run() {
			long beginTime = System.currentTimeMillis();
			for (int i = 0; i < 10000000; i++) {
				Singleton.getInstance();
				//LazySingleton.getInstance();
			}
			System.out
					.println("用时：" + (System.currentTimeMillis() - beginTime));
		}

	}
}
