package UI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

public class Menu extends JFrame{
	private static final long serialVersionUID = 1L;

	public Menu() {
		super("MenuBar");
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
		JMenu menu = new JMenu("Feeds");
		
		JMenuItem j1 = new JMenuItem("Load");
		JMenuItem j2 = new JMenuItem("Save");
		JMenuItem j3 = new JMenuItem("Subscribe");
		JMenuItem j4 = new JMenuItem("Unsubscribe");
		
		menu.add(j1);
		menu.add(j2);
		menu.addSeparator();
		menu.add(j3);
		menu.add(j4);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
	}

	public static void main(String[] args) {
		new Menu();
	}

}
