package UI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class FlowLayouts extends JFrame{
	private static final long serialVersionUID = 1L;

	public FlowLayouts() {
		super("FlowLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setSize(220, 120);
		setComponents();
		setLocationRelativeTo(null);
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
		FlowLayout lm = new FlowLayout(FlowLayout.LEFT);
		setLayout(lm);
		
		JButton a = new JButton("1"); 	add(a);
		JButton b = new JButton("2");	add(b);
		JButton c = new JButton("3");	add(c);
		JButton d = new JButton("4");	add(d);
		JButton e = new JButton("5");	add(e);
		JButton f = new JButton("6");	add(f);
		JButton h = new JButton("7");	add(h);
		JButton i = new JButton("8");	add(i);
		JButton j = new JButton("9");	add(j);
		JButton k = new JButton("0");	add(k);
		
	}

	public static void main(String[] args) {
		new FlowLayouts();
	}

}
