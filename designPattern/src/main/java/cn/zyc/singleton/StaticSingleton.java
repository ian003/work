package cn.zyc.singleton;

public class StaticSingleton {

	private StaticSingleton() {
		System.out.println("static singleton constructor ...");
	}

	private static class SingletonHolder {
		private static StaticSingleton singleton = new StaticSingleton();
	}

	public static StaticSingleton getInstance() {
		return SingletonHolder.singleton;
	}

	public static void createString() {
		System.out.println("lazy create string ...");
	}
}
