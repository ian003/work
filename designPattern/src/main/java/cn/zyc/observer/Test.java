package cn.zyc.observer;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IObserver o1 = new ConcreteObserver("aaa");
		IObserver o2 = new ConcreteObserver("bbb");
		IObserver o3 = new ConcreteObserver("ccc");
		ISubject subject = new ConcreteSubject();
		subject.attach(o1);
		subject.attach(o2);
		subject.attach(o3);
		subject.inform();
		subject.deattach(o1);
		subject.inform();
	}

}
