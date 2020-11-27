import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ThreadsWithInnerClasses extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JTextArea text;

	public ThreadsWithInnerClasses() {
		super("ThreadsWithInnerClasses");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setSize(600, 400);
		setComponents();
		setLocationRelativeTo(null);
		setVisible(true);
		
		addWord(" Norman ", 1000, 20);
		addWord(" Cake   ", 4000, 10);
		addWord(" Melon  ", 6000, 5);
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
	
	private void setComponents()
	{
		text = new JTextArea();
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		add(text);
	}
	
	private void addWord(final String txt, 
			final int delay, final int count)
	{
		new Thread() {
			public void run() {
				for(int i = 0; i<count; ++i) { 
					try {
						Thread.sleep(delay);
						System.out.println(txt);
					} catch (InterruptedException e) {}
					text.append(txt);
				}
			}
		}.start();
	}

	public static void main(String[] args) {
		new ThreadsWithInnerClasses();
	}

}
