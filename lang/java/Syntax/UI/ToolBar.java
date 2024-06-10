package UI;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.UIManager;

public class ToolBar extends JFrame{
	private static final long serialVersionUID = 1L;

	public ToolBar(){
		super("FeedBar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		setComponents();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void setComponents()
	{
		//Create icons
		ImageIcon loadIcon = new ImageIcon("");
		ImageIcon saveIcon = new ImageIcon("");
		ImageIcon subscribeIcon = new ImageIcon("");
		ImageIcon unsubscribeIcon = new ImageIcon("");
		
		//Create buttons
		JButton load = new JButton("Load", loadIcon);
		JButton save = new JButton("Save", saveIcon);
		JButton subscribe = new JButton("Subscribe", subscribeIcon);
		JButton unsubscribe = new JButton("Unsubscribe", unsubscribeIcon);
		
		//Add buttons to tool bar
		JToolBar bar = new JToolBar();
		bar.add(load);
		bar.add(save);
		bar.add(subscribe);
		bar.add(unsubscribe);
		
		//Prepare User-Interface
		JTextArea edit = new JTextArea(8, 40);
		JScrollPane scroll = new JScrollPane(edit);
		BorderLayout bord = new BorderLayout();
		setLayout(bord);
		add("North", bar);
		add("Center", scroll);
		pack();
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
	
	public static void main(String[] args) {
		new ToolBar();
	}

}
