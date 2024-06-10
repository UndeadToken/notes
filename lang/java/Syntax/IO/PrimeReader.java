package IO;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;


public class PrimeReader {
	public static void main(String[] Args) {
		try(FileInputStream file = new
				FileInputStream("400Primes.dat");
			
				BufferedInputStream buff = new 
						BufferedInputStream(file);
				
				DataInputStream data = new 
						DataInputStream(buff)) 
		{
			try {
				while(true) {
					int in = data.readInt();
					System.out.print(in + " ");
				}
			} catch(EOFException eof) {
				buff.close();
			}
			
		} catch(IOException e) {
			System.out.println("Error -- " + e.toString());
		}
	}
}
