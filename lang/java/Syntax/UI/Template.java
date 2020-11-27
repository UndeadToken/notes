package UI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Template extends JFrame{
	private static final long serialVersionUID = 1L;

	public Template() {
		super("Template");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setSize(400, 200);
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
		
		
	}

	public static void main(String[] args) {
		new Template();
	}

}
