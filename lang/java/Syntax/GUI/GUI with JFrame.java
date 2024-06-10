import javax.swing.JFrame;

public class myClass {

	public static void main(String args[]){
		
		mySecondClass MSC = new mySecondClass();
		MSC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MSC.setSize(275,180);
		MSC.setVisible(true);

	}
}


import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class mySecondClass extends JFrame{
	
	private JLabel item1;
	
	public mySecondClass(){
		
		super("The title bar"); // set title	
		setLayout(new FlowLayout()); // set default layout
		
		item1 = new JLabel("This is a label.");
		item1.setToolTipText("Tool Tip");
		
		add(item1);
	}
}
