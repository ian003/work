package cn.zyc.currency.future.jdk;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class RealData implements Callable<String> {

	private String result;

	public RealData(String result) {
		this.result = result;
	}

	@Override
	public String call() throws Exception {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			buffer.append(result + "---");
			if (i == 9)
				buffer.append(result);
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}

}
