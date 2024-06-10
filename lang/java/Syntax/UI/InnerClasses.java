package UI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class InnerClasses extends JFrame{
	private static final long serialVersionUID = 1L;

	public InnerClasses() {
		super("InnerClasses");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		
		KeyAdapter monitor = new KeyAdapter() {
			public void keyTyped(KeyEvent evt){
				setTitle("Inner Classes Baby! " + evt.getKeyChar());
				repaint();
			}
		};
		
		setFocusable(true);
		addKeyListener(monitor);
		
		setLocationRelativeTo(null);
		setVisible(true);
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

	public static void main(String[] args) {
		new InnerClasses();
	}

}
