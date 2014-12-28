package cn.zyc.currency.producerconsumer;

public class Resource {
	private final int data;

	public Resource(int data) {
		this.data = data;
	}

	public Resource(String data) {
		this.data = Integer.valueOf(data);
	}

	public int getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Resource [data=" + data + "]";
	}

}
