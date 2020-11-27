package Java2DGraphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class DrawingText extends JFrame{
	DrawingText()
	{
		super("Drawing Text");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setSize(400, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JPanel panel = new JPanel() {
			
			public void paintComponent(Graphics comp) {
				super.paintComponent(comp);
				Graphics2D comp2D = (Graphics2D) comp;
				comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
						RenderingHints.VALUE_ANTIALIAS_ON);
				
				Font font = new Font("Arial", Font.BOLD, 18);
				FontMetrics metrics = getFontMetrics(font);
				comp2D.setFont(font);
				
				int x = (getSize().width - metrics.stringWidth("Text")) / 2;
				int y = getSize().height / 2;
				
				comp2D.setColor(Color.PINK);
				comp2D.drawString("Text", x, y);
			}
		};
		panel.setBackground(Color.BLACK);
		
		add(panel);
	}
	
	private void setLookAndFeel()
	{
		try{
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
					);
			SwingUtilities.updateComponentTreeUI(this);
		}catch(Exception e){
			System.err.println("Could not use system Look and Feel. \n\n"
					+ e.getMessage());
		}
	}
	
	public static void main(String[] Args) {
		new DrawingText();
	}
}
