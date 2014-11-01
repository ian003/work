package cn.zyc.jdk.observer;

import java.util.Observable;
import java.util.Observer;

public class MyOberver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(o.getClass().getName() + "---" + arg);
	}
}
