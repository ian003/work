package cn.zyc.decorator;

public class PacketBodyCreator implements IPacketCreator {

	@Override
	public String handleContent() {
		return "body content";
	}

}
