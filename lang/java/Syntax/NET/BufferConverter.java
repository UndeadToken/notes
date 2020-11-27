package NET;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class BufferConverter {

	public static void main(String[] args) {
		try {
			// Read byte data into a byte buffer
			String data = "friends.dat";
			
			FileInputStream inData = new FileInputStream(data);
			FileChannel inChannel = inData.getChannel();
			long inSize = inChannel.size();
			
			ByteBuffer source = ByteBuffer.allocate( (int)inSize);
			inChannel.read(source, 0);
			source.position(0);
			
			// Output original data
			System.out.println("Original byte data");
			for(int i = 0; source.remaining() > 0; i++) {
				System.out.println(source.get());
			}
			
			// Convert byte data to character data
			source.position(0);
			Charset ascii = Charset.forName("US-ASCII");
			CharsetDecoder toAscii = ascii.newDecoder();
			CharBuffer destination = toAscii.decode(source);
			destination.position(0);
			
			// Output character data
			System.out.println("\nNew character data");
			for(int i = 0; destination.remaining() > 0; i++) {
				System.out.println(destination.get());
			}
			
		} catch(FileNotFoundException fne) {
			System.out.println(fne.getMessage());
			
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

}
