package cn.zyc.singleton;

import java.io.Serializable;

public class SerSingleton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3610468193100225206L;

	private SerSingleton() {
		System.out.println("ser singleton constructor ...");
	}

	private static SerSingleton singleton = new SerSingleton();

	public static SerSingleton getInstance() {
		return singleton;
	}

	public static void createString() {
		System.out.println("ser create string ...");
	}
	
	private Object readResolve(){
		return singleton;
	}
}
