package cn.zyc.jdk.observer;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyOberver mo1 = new MyOberver();
		MyOberver mo2 = new MyOberver();
		
		MySubject ms = new MySubject();
		ms.addObserver(mo1);
		ms.addObserver(mo2);
		ms.setChanged();
		ms.notifyObservers();
	}

}
