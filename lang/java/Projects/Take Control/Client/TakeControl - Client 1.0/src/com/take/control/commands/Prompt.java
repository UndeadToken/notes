package com.take.control.commands;

import java.util.Vector;

import javax.swing.JOptionPane;

public class Prompt {
	
	// Confirm dialog
	public void confirmDialog(Vector<String> params)
	{
		int response = JOptionPane.showConfirmDialog(null, 
				params.get(0), params.get(1),
				JOptionPane.YES_NO_OPTION,
				JOptionPane.ERROR_MESSAGE);
	}
	
	// Input dialog
	public void inputDialog(Vector<String> params)
	{
		String response = JOptionPane.showInputDialog(null, 
				params.get(0));
	}
	
	// Input dialog with question
	public void inputDialogQ(Vector<String> params)
	{
		String response = JOptionPane.showInputDialog(null, 
				params.get(0), params.get(1),
				JOptionPane.QUESTION_MESSAGE);
	}
	
	// Message dialog
	public void messageDialog(Vector<String> params)
	{
		JOptionPane.showMessageDialog(null,
				params.get(0));
	}
	
	// Warning dialog
	public void warningDialog(Vector<String> params)
	{
		JOptionPane.showMessageDialog(null, params.get(0), 
				params.get(1), JOptionPane.WARNING_MESSAGE);
	}
	
	// Option dialog
	public void optionDialog(Vector<String> params)
	{
		String[] args = { 
				params.get(2), 
				params.get(3),
				params.get(4)
				};
		
		int response = JOptionPane.showOptionDialog(null, 
				params.get(0), params.get(1), 0, 
				JOptionPane.INFORMATION_MESSAGE, 
				null,
				args,
				params.get(4));
	}
}
