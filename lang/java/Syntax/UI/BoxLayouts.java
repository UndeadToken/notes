package UI;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class BoxLayouts extends JFrame{
	private static final long serialVersionUID = 1L;

	public BoxLayouts() {
		super("BoxLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setSize(400, 170);
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
			System.out.println(e.getMessage());
		}
	}
	
	private void setComponents()
	{
		//Create top panel
		JPanel commandPane = new JPanel();
		BoxLayout horizontal = new BoxLayout(commandPane, 
				BoxLayout.X_AXIS);
		commandPane.setLayout(horizontal);
		
		//Create buttons
		JButton subscribe = new JButton("Subscribe");
		JButton unsubscribe = new JButton("Unsubscribe");
		JButton refresh = new JButton("Refresh");
		JButton save = new JButton("Save");
		
		//Add buttons
		commandPane.add(subscribe);
		commandPane.add(unsubscribe);
		commandPane.add(refresh);
		commandPane.add(save);
		
		//Create botom panel
		//JPanel textPane = new JPanel();
		JTextArea text = new JTextArea(4, 30);
		JScrollPane scrollPane = new JScrollPane(text);
		
		//Add Components
		FlowLayout flow = new FlowLayout();
		setLayout(flow);
		add(commandPane);
		add(scrollPane);
	}

	public static void main(String[] args) {
		new BoxLayouts();
	}

}






