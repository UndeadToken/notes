package IO;
import java.io.FileInputStream;
import java.io.IOException;


public class ByteReader {
	public static void main(String[] Args) {
		try (
			FileInputStream file = new FileInputStream("save.gif");	
			) {
			
			boolean eof = false;
			int count = 0;
			while(!eof) {
				int input = file.read();
				System.out.println(input + " ");
				
				if(input == -1)
					eof = true;
				else
					count++;
			}
			
			file.close();
			
		} catch (IOException e){
			System.out.println("Error: " + e.toString());
		}
		
	}
}
