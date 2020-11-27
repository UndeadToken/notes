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
import javax.swing.event.*;

public class GUI extends JFrame{
    private JList list;
    private static String[] ColourNames = {"black", "blue", "red", "white"};
    private static Color[] colours = {Color.BLACK, Color.BLUE, Color.RED, Color.WHITE};
    
    public GUI(){
    	super("The title");
    	setLayout(new FlowLayout());
    	
    	list = new JList(ColourNames);
    	list.setVisibleRowCount(4);
    	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	add(new JScrollPane(list));
    	
    	list.addListSelectionListener(
    	          new ListSelectionListener(){
    	        	  public void valueChanged(ListSelectionEvent event){
    	        		  getContentPane().setBackground(colours[list.getSelectedIndex()]);
    	        	  }
    	          }
    	);
    	
    }
    
}



