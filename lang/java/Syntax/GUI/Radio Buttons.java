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

	private JTextField tf;
	private Font PF;
	private Font BF;
	private Font IF;
	private Font BIF;
	private JRadioButton PR;
	private JRadioButton BR;
	private JRadioButton IR;
	private JRadioButton BIR;
	private ButtonGroup Group;
	
	public GUI(){
		super("the title");
		setLayout(new FlowLayout());
		
		tf = new JTextField("This is a textfield", 25);
		add(tf);
		
		PR = new JRadioButton("Plain", true);
		BR = new JRadioButton("Bold", false);
		IR = new JRadioButton("Italic", false);
		BIR = new JRadioButton("Bold & Italic", false);
		add(PR);
		add(BR);
		add(IR);
		add(BIR);
		
		Group = new ButtonGroup();
		Group.add(PR);
		Group.add(BR);
		Group.add(IR);
		Group.add(BIR);
		
		PF = new Font("serif", Font.PLAIN, 14);
		BF = new Font("serif", Font.BOLD, 14);
		IF = new Font("serif", Font.ITALIC, 14);
		BIF = new Font("serif", Font.BOLD + Font.ITALIC, 14);
		
		tf.setFont(PF);
		
		PR.addItemListener(new HandlerClass(PF));
		BR.addItemListener(new HandlerClass(BF));
		IR.addItemListener(new HandlerClass(IF));
		BIR.addItemListener(new HandlerClass(BIF));
		
	}
       
	private class HandlerClass implements ItemListener{
		private Font font;
		
		public HandlerClass(Font f){
			font = f;
		}
		
		public void itemStateChanged(ItemEvent event){
			tf.setFont(font);
		}
		
	}
	
}



