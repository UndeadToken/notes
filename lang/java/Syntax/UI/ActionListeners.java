package UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ActionListeners extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private static JButton b1;
	private static JButton b2;

	public ActionListeners() {
		super("ActionListener");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setLocationRelativeTo(null);
		setComponents();
		pack();
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
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		
		b1 = new JButton("              B1              ");
		b2 = new JButton("              B2              ");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);
		add(b2);
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		
		// Call appropriate method - Use instanceof to compare classes
		if(source == b1){ 
			setTitle("b1");
		}
		else if(source == b2){
			setTitle("b2");
		}
	}

	public static void main(String[] args) {
		new ActionListeners();
	}
}
