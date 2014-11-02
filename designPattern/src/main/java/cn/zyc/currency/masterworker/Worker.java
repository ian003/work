package cn.zyc.currency.masterworker;

import java.util.Map;
import java.util.Queue;

public class Worker implements Runnable {

	private Queue<Object> workQueue;
	private Map<String, Object> resultMap;

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public void setWorkQueue(Queue<Object> workQueue) {
		this.workQueue = workQueue;
	}

	public Object handle(Object input) {
		return input;
	}

	@Override
	public void run() {
		while (true) {
			Object o = workQueue.poll();
			if (o == null)
				return;
			Object result = handle(o);
			resultMap.put(Integer.toString(o.hashCode()), result);

		}
	}

}
