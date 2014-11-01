package cn.zyc.observer;

public class ConcreteObserver implements IObserver {

	private String name;

	public ConcreteObserver(String name) {
		this.name = name;
	}

	@Override
	public void update() {
		System.out.println(this.name + " ---> update observer");
	}
}
