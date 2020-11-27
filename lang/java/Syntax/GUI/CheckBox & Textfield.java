import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import javax.swing.JFrame;

public class myClass {
	public static void main(String args[]){
		   GUI gui = new GUI();
		   gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   gui.setSize(400, 200);
		   gui.setVisible(true);
		   
		   
    }
}


public class GUI extends JFrame{

	private JTextField textField;
	private JCheckBox checkBox;
	private JCheckBox italicBox;
	
	public GUI(){
		super("The title");
		setLayout(new FlowLayout());
		
		textField = new JTextField("Textfield", 20);
		textField.setFont(new Font("serif", Font.PLAIN, 14));
		add(textField);
		
		checkBox = new JCheckBox("Bold");
		italicBox = new JCheckBox("Italic");
		add(checkBox);
		add(italicBox);
		
		
		HandlerClass handler = new HandlerClass();
		checkBox.addItemListener(handler);
		italicBox.addItemListener(handler);
	}
	
	private class HandlerClass implements ItemListener{
		public void itemStateChanged(ItemEvent event){
			
			Font font = null;
			
			if(checkBox.isSelected() && italicBox.isSelected())
				font = new Font("serif", Font.BOLD + Font.ITALIC, 14);
			else if (checkBox.isSelected())
				font = new Font("serif", Font.BOLD, 14);
			else if(italicBox.isSelected())
				font = new Font("serif", Font.ITALIC, 14);
			else
				font = new Font("serif", Font.PLAIN, 14);
			
			textField.setFont(font);
			
		}
		
	}
	
}
