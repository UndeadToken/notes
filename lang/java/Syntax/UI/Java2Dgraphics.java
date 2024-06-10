package UI;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Java2Dgraphics {
	
	public static Font loadFont(String fontPath)
	{
		Font font;
		try {
			File ttf = new File(fontPath);
			FileInputStream fis = new FileInputStream(ttf);
			font = Font.createFont(Font.TRUETYPE_FONT, fis);
			
		} catch(IOException | FontFormatException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return font;
	}
}
