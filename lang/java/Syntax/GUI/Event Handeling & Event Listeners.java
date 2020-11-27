import javax.swing.JFrame;

public class myClass {

	public static void main(String args[]){
		
		mySecondClass MSC = new mySecondClass();
		MSC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MSC.setSize(350,100);
		MSC.setVisible(true);
		

	}
}

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class mySecondClass extends JFrame{
	
	private JTextField item1;
	private JTextField item2;
	private JTextField item3;
	private JPasswordField passwordfield;
	
	public mySecondClass(){		
		super("Title for window");
		setLayout(new FlowLayout());
		
		item1 = new JTextField(10);
		add(item1);
		
		item2 = new JTextField("Enter text here:");
		add(item2);
		
		item3 = new JTextField("Uneditble", 20);
		item3.setEditable(false);
		add(item3);
		
		passwordfield = new JPasswordField("...");
		add(passwordfield);
		
		theHandler handler = new theHandler();
		item1.addActionListener(handler);
		item2.addActionListener(handler);
		item3.addActionListener(handler);
		passwordfield.addActionListener(handler);
	}
	
	private class theHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String string="";
			
			if(event.getSource() == item1)
				string=String.format("Field 1: %s", event.getActionCommand());
				
			else if(event.getSource() == item2)
					string=String.format("Field 2: %s", event.getActionCommand());
					
			else if(event.getSource() == item3)
				string=String.format("Field 3: %s", event.getActionCommand());
			
			else if(event.getSource()==passwordfield)
				string=String.format("password field is : %s", event.getActionCommand());
			
			JOptionPane.showMessageDialog(null, string);
		}
	}
}

