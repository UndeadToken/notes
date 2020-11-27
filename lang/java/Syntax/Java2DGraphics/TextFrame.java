package Java2DGraphics;

import javax.swing.JFrame;

public class TextFrame extends JFrame{
	public TextFrame(String text, String fontName)
	{
		super("Show font");
		setSize(425, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TextFramePanel sf = new TextFramePanel(text, fontName);
		add(sf);
		setVisible(true);
	}
	
	public static void main(String[] Args)
	{
		if(Args.length < 1)
		{
			System.out.println("Usage: Jave TextFrame message font");
			System.exit(-1);
		}
		TextFrame frame = new TextFrame(Args[0], Args[1]);
	}
}
