package UI;

import javax.swing.JOptionPane;

public class DialogBoxes {
	
	private static void confirmDialog()
	{
		int response = JOptionPane.showConfirmDialog(null, 
				"Error reading file. Want to try again?",
				"File Input Error",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.ERROR_MESSAGE);
		System.out.print(response);
	}
	
	private static void inputDialog()
	{
		// 1
		String response = JOptionPane.showInputDialog(null, 
				"Enter your name: ");
		System.out.print(response);
		
		// 2
		response = JOptionPane.showInputDialog(null, 
				"What is your ZipCode?",
				"Enter ZipCode:",
				JOptionPane.QUESTION_MESSAGE);
		System.out.print(response);
	}
	
	private static void messageDialog()
	{
		// 1
		JOptionPane.showMessageDialog(null, 
				"The program has been uninstalled.");
		
		// 2
		JOptionPane.showMessageDialog(null, 
				"An asteroid has destroyed the earth.",
				"Asteroid destruction alert!",
				JOptionPane.WARNING_MESSAGE);
	}
	
	private static void optionDialog()
	{
		String[] gender = { "Male", "Female", 
				"None of yor business."};
		int response = JOptionPane.showOptionDialog(null, 
				"What is your gender?", 
				"Gender", 0, 
				JOptionPane.INFORMATION_MESSAGE, 
				null,
				gender,
				gender[2]);
		System.out.println("You chose " + gender[response]);
		
	}
	
	public static void main(String[] args) {
		confirmDialog();
		inputDialog();
		messageDialog();
		optionDialog();
	}

}
