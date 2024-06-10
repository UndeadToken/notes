package IO;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class SourceWriter {

	public static void main(String[] args) {
		try (
			FileWriter writer = new
				FileWriter("alphabet.txt");
				
			BufferedWriter buff = new 
					BufferedWriter(writer);
			)
		{
			for(int i = 65; i < 91; i++) {
				buff.write( (char)i );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
