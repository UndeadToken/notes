package UI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class BorderLayouts extends JFrame{
	private static final long serialVersionUID = 1L;

	public BorderLayouts() {
		super("BorderLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setSize(400, 400);
		setLayout(new BorderLayout());
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
		JButton north = new JButton("North");	
		JButton east = new JButton("East");		
		JButton south = new JButton("South");	
		JButton west = new JButton("West");		
		JButton centre = new JButton("Centre");	
		add(north, BorderLayout.NORTH);
		add(east, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);
		add(west, BorderLayout.WEST);
		add(centre, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new BorderLayouts();
	}

}
