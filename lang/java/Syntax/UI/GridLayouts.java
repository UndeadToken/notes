package UI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class GridLayouts extends JFrame{
	private static final long serialVersionUID = 1L;

	public GridLayouts()
	{
		super("GridLayout");
		setSize(260, 260);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLookAndFeel();
		setComponents();
		setResizable(false);
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
		JPanel pane = new JPanel();
		GridLayout family = new GridLayout(3, 3, 10, 10);
		pane.setLayout(family);
		
		JButton marcia = new JButton("Marcia");		pane.add(marcia);
		JButton carol = new JButton("Carol");		pane.add(carol);
		JButton greg = new JButton("Greg");			pane.add(greg);
		JButton jan = new JButton("Jan");			pane.add(jan);
		JButton alice = new JButton("Alice");		pane.add(alice);
		JButton peter = new JButton("Peter");		pane.add(peter);
		JButton cindy = new JButton("Cindy");		pane.add(cindy);
		JButton mike = new JButton("Mike");			pane.add(mike);
		JButton bobby = new JButton("Bobby");		pane.add(bobby);
		
		add(pane);
	}
	
	// Main
	public static void main(String[] Args)
	{
		new GridLayouts();
	}
}
