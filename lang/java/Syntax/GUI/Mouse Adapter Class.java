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
	private String details;
	private JLabel statusbar;
	
	public GUI(){
		super("title");
		
		statusbar = new JLabel("Statusbar...");
		add(statusbar, BorderLayout.SOUTH);
		addMouseListener(new Mouseclass());
	}
	
	private class Mouseclass extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			details = String.format("You clicked %d time(s).", event.getClickCount());
			
			if(event.isMetaDown())
				details += "with the right mouse button.";
			else if(event.isAltDown())
				details += "with centre mouse button.";
			else
				details += "with left mouse button";
			statusbar.setText(details);
		}
	}
    
}



