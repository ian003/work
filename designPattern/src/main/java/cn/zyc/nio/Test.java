package cn.zyc.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream(new File(
				"src/main/resources/d.txt"));
		FileOutputStream out = new FileOutputStream("src/main/resources/c.txt");
		FileChannel in_channel = in.getChannel();
		FileChannel out_channel = out.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (true) {
			buffer.clear();
			int len = in_channel.read(buffer);
			if (len == -1)
				break;
			buffer.flip();
			out_channel.write(buffer);
		}
		in_channel.close();
		out_channel.close();
	}

}
