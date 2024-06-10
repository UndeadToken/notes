package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class TabPane extends JFrame{
	private static final long serialVersionUID = 1L;

	public TabPane() {
		super("TabPane");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setSize(480, 218);
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
		JPanel mainSettings = new JPanel();
		JPanel advancedSettings = new JPanel();
		JPanel privacySettings = new JPanel();
		JPanel emailSettings = new JPanel();
		JPanel securitySettings = new JPanel();
		
		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Main", mainSettings);
		tabs.addTab("Advanced", advancedSettings);
		tabs.addTab("Privacy", privacySettings);
		tabs.addTab("Email", emailSettings);
		tabs.addTab("Security", securitySettings);
		add(tabs);
	}

	public static void main(String[] args) {
		new TabPane();
	}

}
