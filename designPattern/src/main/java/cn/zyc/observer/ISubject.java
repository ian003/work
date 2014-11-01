package cn.zyc.observer;

public interface ISubject {

	void attach(IObserver observer);

	void deattach(IObserver observer);

	void inform();
}
