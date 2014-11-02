package cn.zyc.currency.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	// 任务对列
	private Queue<Object> workQueue = new ConcurrentLinkedQueue<>();
	// 子任务进程
	private Map<String, Thread> threadMap = new HashMap<String, Thread>();
	// 子任务结果集
	private Map<String, Object> resultMap = new ConcurrentHashMap<>();

	public Master(Worker worker, int workerCount) {
		worker.setWorkQueue(workQueue);
		worker.setResultMap(resultMap);
		for (int i = 0; i < workerCount; i++) {
			String id = Integer.toString(i);
			threadMap.put(id, new Thread(worker, "work-" + id));
		}
	}

	// 判断所有的子进程是否全部完成
	public boolean isComplete() {
		for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
			if (entry.getValue().getState() != Thread.State.TERMINATED) {
				return false;
			}
		}
		return true;
	}

	public void submit(Object object) {
		workQueue.add(object);
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void execute() {
		for (Entry<String, Thread> entry : threadMap.entrySet()) {
			entry.getValue().start();
		}
	}

}
