package IO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class InputOutput {

	// File stream
	private static void FileStream()
	{
		char sep = File.separatorChar;
		try {
			FileInputStream fis = 
					new FileInputStream(sep + "data.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}

}
