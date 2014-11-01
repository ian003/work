package cn.zyc.decorator;

public class PacketHtmlDecorator extends PacketDecorator {

	public PacketHtmlDecorator(IPacketCreator iPacketCreator) {
		super(iPacketCreator);
	}

	@Override
	public String handleContent() {
		return "<html><body>" + iPacketCreator.handleContent()
				+ "</body></html>";
	}
}
