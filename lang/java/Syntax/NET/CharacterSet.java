package NET;

import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class CharacterSet {

	public static void main(String[] args) {
		java.nio.ByteBuffer netBuffer = java.nio.ByteBuffer.allocate(6);
		netBuffer.putInt(4);    // 4 bytes
		netBuffer.putChar('2'); // 2 bytes
		netBuffer.position(0);
		
		Charset set = Charset.forName("UTF-8");
		CharsetDecoder decoder = set.newDecoder();
		try {
			CharBuffer netText = decoder.decode(netBuffer);
		} catch (CharacterCodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
