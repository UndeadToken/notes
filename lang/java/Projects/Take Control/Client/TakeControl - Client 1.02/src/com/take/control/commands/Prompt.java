package com.take.control.commands;

import java.util.Vector;

import javax.swing.JOptionPane;

import com.take.control.framework.Client;

public class Prompt {
	
	// Confirm dialog
	public void confirmDialog(Vector<String> params)
	{
		// Display dialog
		int response = JOptionPane.showConfirmDialog(null, 
				params.get(0), params.get(1),
				JOptionPane.YES_NO_OPTION,
				JOptionPane.ERROR_MESSAGE);
		
		// Define response
		String r = "User response: ";
		switch(response)
		{
			case JOptionPane.YES_OPTION:
				r += "YES";
				break;
				
			case JOptionPane.NO_OPTION:
				r += "NO";
				break;
				
			case JOptionPane.CANCEL_OPTION:
				r += "CANCEL";
				break;
		}
		Client.sendResponse(r);
	}
	
	// Input dialog
	public void inputDialog(Vector<String> params)
	{
		String response = JOptionPane.showInputDialog(null, 
				params.get(0));
		Client.sendResponse(response);
	}
	
	// Input dialog with question
	public void inputDialogQ(Vector<String> params)
	{
		String response = JOptionPane.showInputDialog(null, 
				params.get(0), params.get(1),
				JOptionPane.QUESTION_MESSAGE);
		Client.sendResponse(response);
	}
	
	// Message dialog
	public void messageDialog(Vector<String> params)
	{
		JOptionPane.showMessageDialog(null,
				params.get(0));
		Client.sendResponse("Display message dialog: Success");
	}
	
	// Warning dialog
	public void warningDialog(Vector<String> params)
	{
		JOptionPane.showMessageDialog(null, params.get(0), 
				params.get(1), JOptionPane.WARNING_MESSAGE);
		Client.sendResponse("Display warning dialog: Success");
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
		
		// Define response
		String r = "User response: ";
		switch(response)
		{
			case JOptionPane.CLOSED_OPTION:
				r += "CANCEL";
				break;
						
			default:
				r += args[response];
				break;
		}
		Client.sendResponse(r);
	}
}
