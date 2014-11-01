package cn.zyc.proxy;

public class Main {

	public static void main(String[] args) {
		IDBQuery proxy = new DBQueryProxy();
		System.out.println(proxy.query());;
	}
}
