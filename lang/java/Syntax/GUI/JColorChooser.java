import javax.swing.*;

public class myClass {
	public static void main(String args[]){		
		
		sClass F = new sClass();
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	}
}


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class sClass extends JFrame{
	private JButton b;
	private Color color = (Color.WHITE);
	private JPanel panel;
	
	public sClass(){
		super("title");
		panel = new JPanel();
		panel.setBackground(color);
		
		b = new JButton("Choose color");
		b.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent event){
							color = JColorChooser.showDialog(null, "choose colour.", color);
							if(color==null)
								color=(Color.WHITE);
							
							panel.setBackground(color);
						}
					}
		);
		
		add(panel, BorderLayout.CENTER);
		add(b, BorderLayout.SOUTH);
		setSize(425, 540);
		setVisible(true);
	}
	
}
