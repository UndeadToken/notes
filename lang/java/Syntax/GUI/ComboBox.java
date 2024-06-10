import javax.swing.JFrame;

public class myClass {
	public static void main(String args[]){
		   GUI gui = new GUI();
		   gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   gui.setSize(400, 200);
		   gui.setVisible(true);
		   
		   
    }
}

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GUI extends JFrame{
	private JComboBox Box;
	private JLabel Picture;
	
	private static String[] filename = {"pic.png", "x.png"};
	private Icon[] Pics = {new ImageIcon(getClass().getResource(filename[0])), new ImageIcon(getClass().getResource(filename[1]))};
	
	public GUI(){
		super("the title");
		setLayout(new FlowLayout());
		
		Box = new JComboBox(filename);
		
		Box.addItemListener(
				new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						if(event.getStateChange()==ItemEvent.SELECTED){
							Picture.setIcon(Pics[Box.getSelectedIndex()]);
						}
					}
				}	
		);
		
		add(Box);
		Picture = new JLabel(Pics[0]);
		add(Picture);
	}
}



