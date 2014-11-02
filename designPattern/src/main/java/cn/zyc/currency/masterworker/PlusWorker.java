package cn.zyc.currency.masterworker;

/**
 * 求立方和
 * 
 * @author ian
 * 
 */
public class PlusWorker extends Worker {

	@Override
	public Object handle(Object input) {
		Integer i = (Integer) input;
		return i * i * i;
	}

}
