import javax.swing.*;
import java.awt.*;

public class myClass {
	public static void main(String args[]){		
		
		JFrame F = new JFrame();
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		sClass s = new sClass();
		F.setBackground(Color.WHITE);
		F.add(s);
		F.setSize(500, 270);
		F.setVisible(true);
	}
}


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class sClass extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.BLUE);
		g.drawLine(10, 25, 200, 45);
		
		g.setColor(Color.RED);
		g.drawRect(10, 55, 100, 30);
		
		g.setColor(Color.GREEN);
		g.fillOval(10, 95, 100, 30);
		
		g.setColor(Color.ORANGE);
		g.fill3DRect(10, 160, 100, 50, true);
	}
	
}
