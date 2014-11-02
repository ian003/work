package cn.zyc.currency.future;

/**
 * 虚拟的数据
 * 
 * @author ian
 * 
 */
public class FutureData implements Data {

	private RealData realData;
	private boolean ready = false;

	public synchronized void setRealData(RealData realData) {
		if (ready) {
			return;
		}
		this.realData = realData;
		ready = true;
		notifyAll();
	}

	@Override
	public synchronized String getResult() {
		try {
			while (!ready) {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return realData.getResult();
	}
}
