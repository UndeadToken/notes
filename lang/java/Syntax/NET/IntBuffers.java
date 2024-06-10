package NET;

import java.nio.IntBuffer;

public class IntBuffers {

	public static void main(String[] args) {
		int[] temps = {90, 20, 30, 40, 50, 60, 70};
		IntBuffer tempBuffer = IntBuffer.allocate(temps.length);
		
		for(int i = 0; i < temps.length; i++) {
			float celsius = ( (float) temps[i] - 32 ) / 9 * 5;
			tempBuffer.put( (int) celsius);
		}
		tempBuffer.position(0                                                                                                           );
		
		for(int i = 0; tempBuffer.remaining() > 0; i++) {
			System.out.println(tempBuffer.get());
		}
	}

}
