package cn.zyc.decorator;

public abstract class PacketDecorator implements IPacketCreator {

	protected IPacketCreator iPacketCreator;

	public PacketDecorator(IPacketCreator iPacketCreator) {
		this.iPacketCreator = iPacketCreator;
	}
}
