package NET;

public class ByteBuffer {

	public static void main(String[] args) {
		
		java.nio.ByteBuffer buffer = java.nio.ByteBuffer.allocate(6);
		buffer.putInt(4);    // 4 bytes
		buffer.putChar('2'); // 2 bytes
		buffer.position(0);
		
	}

}
