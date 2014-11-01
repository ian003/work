package cn.zyc.singleton;

public class LazySingleton {

	private LazySingleton() {
		System.out.println("lazy singleton constructor ...");
	}

	private static LazySingleton singleton = null;

	public static synchronized LazySingleton getInstance() {
		if (null == singleton)
			singleton = new LazySingleton();
		return singleton;
	}

	public static void createString() {
		System.out.println("lazy create string ...");
	}
}
