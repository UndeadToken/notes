package Java2DGraphics;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class TextFramePanel extends JPanel{
	String text;
	String fontName;
	
	public TextFramePanel(String text, String fontName)
	{
		super();
		this.text = text;
		this.fontName = fontName;
	}
	
	public void paintComponent(Graphics comp)
	{
		super.paintComponent(comp);
		Graphics2D comp2D = (Graphics2D) comp;
		comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		Font font = new Font(fontName, Font.BOLD, 18);
		FontMetrics metrics = getFontMetrics(font);
		comp2D.setFont(font);
		
		int x = (getSize().width - metrics.stringWidth(text)) / 2;
		int y = getSize().height / 2;
		
		comp2D.drawString(text, x, y);
	}
}







