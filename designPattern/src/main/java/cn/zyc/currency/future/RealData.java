package cn.zyc.currency.future;

import java.util.concurrent.TimeUnit;

/**
 * 真实的数据
 * 
 * @author ian
 * 
 */
public class RealData implements Data {

	private final String result;

	public RealData(String param) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			buffer.append(param + "---");
			if (i == 9)
				buffer.append(param);
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		result = buffer.toString();
	}

	@Override
	public String getResult() {
		return result;
	}
}
