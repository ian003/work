package cn.zyc.singleton;

public class Singleton {

	private Singleton() {
		System.out.println("singleton constructor ...");
	}

	private static Singleton singleton = new Singleton();

	public static Singleton getInstance() {
		return singleton;
	}
	
	public static void createString(){
		System.out.println("create string ...");
	}
}
