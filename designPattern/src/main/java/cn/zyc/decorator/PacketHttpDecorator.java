package cn.zyc.decorator;

public class PacketHttpDecorator extends PacketDecorator {

	public PacketHttpDecorator(IPacketCreator iPacketCreator) {
		super(iPacketCreator);
	}

	@Override
	public String handleContent() {
		return "Cache-controller:no-cache" + iPacketCreator.handleContent();
	}

}
