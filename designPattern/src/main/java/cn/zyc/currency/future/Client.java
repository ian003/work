package cn.zyc.currency.future;

public class Client {
	public Data request(final String param) {
		final FutureData futureData = new FutureData();
		new Thread() {
			@Override
			public void run() {
				RealData realData = new RealData(param);
				futureData.setRealData(realData);
			}
		}.start();
		return futureData;
	}
}
