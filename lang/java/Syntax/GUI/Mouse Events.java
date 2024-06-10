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
		private JPanel mousepanel;
		private JLabel statusbar;
		
		public GUI(){
			super("title");
			
			mousepanel = new JPanel();
			mousepanel.setBackground(Color.WHITE);
			
			add(mousepanel, BorderLayout.CENTER);
			
			statusbar = new JLabel("Default");
			add(statusbar, BorderLayout.SOUTH);
			
			HandlerClass handler = new HandlerClass();
			mousepanel.addMouseListener(handler);
			mousepanel.addMouseMotionListener(handler);
			
		}
		
		private class HandlerClass implements MouseListener, MouseMotionListener{
			public void mouseClicked(MouseEvent event){
				statusbar.setText(String.format("Mouse clicked at: %d,%d", event.getX(), event.getY()));
			}		
			public void mousePressed(MouseEvent event){
				statusbar.setText("You pressed down the mouse.");
			}			
			public void mouseReleased(MouseEvent event){
				statusbar.setText("You released the mouse.");
			}			
			public void mouseEntered(MouseEvent event){
				statusbar.setText("You entered the area");
				mousepanel.setBackground(Color.YELLOW);
			}	
			public void mouseExited(MouseEvent event){
				statusbar.setText("Mouse has left the area");
				mousepanel.setBackground(Color.WHITE);
			}
			
			public void mouseDragged(MouseEvent event){
				statusbar.setText("Your dragging the mouse");
			}
			public void mouseMoved(MouseEvent event){
				statusbar.setText("You moved the mouse");
			}
		}
    
}



