package cn.zyc.jdk.observer;

import java.util.Observable;

public class MySubject extends Observable {

	@Override
	protected synchronized void setChanged() {
		super.setChanged();
	}
	
}
