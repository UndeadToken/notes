import javax.swing.*;

public class myClass {
	public static void main(String args[]){		
		
		JFrame F = new JFrame("Graphics");
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		sClass s = new sClass();
		F.add(s);
		F.setSize(400, 250);
		F.setVisible(true);
	}
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class sClass extends JPanel{

	public void paintComponent(Graphics g){
		super.paintComponents(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.BLUE);
		g.fillRect(20, 20, 100, 30 );
		
		g.setColor(new Color(20,30,30));
		g.fillRect(20, 60, 100, 30);
		
		g.setColor(Color.RED);
		g.drawString("Is this not graphics?", 20, 120);
		
	}
}
