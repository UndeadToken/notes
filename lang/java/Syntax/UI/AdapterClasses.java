package UI;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class AdapterClasses extends JFrame{
	private static final long serialVersionUID = 1L;
	
	JLabel keyLabel = new JLabel("Hit any key");

	public AdapterClasses() {
		super("AdapterClass");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setComponents();
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
	
	private void setComponents()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		KeyMonitor monitor = new KeyMonitor(this);
		setFocusable(true);
		addKeyListener(monitor);
		add(keyLabel);
	}

	public static void main(String[] args) {
		new AdapterClasses();
	}

}
