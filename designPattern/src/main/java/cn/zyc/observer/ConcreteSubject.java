package cn.zyc.observer;

import java.util.Vector;

public class ConcreteSubject implements ISubject {

	private Vector<IObserver> vector = new Vector<>();

	@Override
	public void attach(IObserver observer) {
		vector.addElement(observer);
	}

	@Override
	public void deattach(IObserver observer) {
		vector.removeElement(observer);
	}

	@Override
	public void inform() {
		for (IObserver obj : vector) {
			obj.update();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
