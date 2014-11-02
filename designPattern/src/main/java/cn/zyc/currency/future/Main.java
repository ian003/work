package cn.zyc.currency.future;

import java.util.concurrent.TimeUnit;

/**
 * future 模式
 * 
 * @author ian
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = new Client();
		Data data = client.request("goods");
		System.out.println("请求完毕");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("data: " + data.getResult());
	}

}
