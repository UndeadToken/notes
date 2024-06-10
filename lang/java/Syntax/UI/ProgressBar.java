package UI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class ProgressBar extends JFrame{
	private static final long serialVersionUID = 1L;
	
	JProgressBar current;
	JTextArea out;
	JButton find;
	//Thread runner;
	int num;
	
	public ProgressBar() {
		super("ProgressBar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setSize(205, 68);
		setComponents();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private static void setLookAndFeel()
	{
		try{
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
					);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void setComponents()
	{
		current = new JProgressBar(0, 100);
		current.setValue(0);
		current.setStringPainted(true);
		add(current);
	}
	
	public void iterate() 
	{
		while(num < 100.1) {
			current.setValue(num);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
			++num;
		}
	}
	
	public static void main(String[] args) {
		ProgressBar bar = new ProgressBar();
		bar.iterate();
	}

}
