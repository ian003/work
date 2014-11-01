package cn.zyc.decorator;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IPacketCreator ipc = new PacketHttpDecorator(new PacketHtmlDecorator(
				new PacketBodyCreator()));
		System.out.println(ipc.handleContent());
	}

}
