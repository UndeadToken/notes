package com.take.control.framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Help extends JFrame implements ListSelectionListener {
	private static final long serialVersionUID = 1L;
	
	
	// Store command items
	private JList items;
	
	// Define selected item properties
	private JLabel selItem;
	private JLabel selParam;
	private JLabel description;
	private JLabel usages;
	
	
	// Parameter values for each item
	private int[] paramValues = {
			1, 2, 1, 2, 1, 2, 5, 0, 1
	};
	
	// Command item usage examples
	private String[] usage = {
			"Usage: url-www.google.com",
			"Usage: confirmDialog-text-title",
			"Usage: inputDialog-text",
			"Usage: inputDialogQ-text-title",
			"Usage: messageDialog-text",
			"Usage: warningDialog-text-title",
			"Usage: optionDialog-text-title-val-val-val",
			"Usage: blankWindow",
			"Usgae: imageWindow-fully_qualified_url"
	};
	
	// Command item descriptions
	private String[] descriptions = {
			"Navigates user to URL",
			"Displays confirmation-dialog box",
			"Displays input-dialog box",
			"Displays question input-dialog",
			"Displays question-dialog box",
			"Displays warning-dialog box",
			"Displays options-dialog box",
			"Displays blank window",
			"Displays fullscreen image"
	};

	// Initialise help menu
	public Help()
	{
		setTitle("Help");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLookAndFeel();
		setComponents();
	}
	
	// Set window decorations
	private void setLookAndFeel()
	{
		try{
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName()
			);
			SwingUtilities.updateComponentTreeUI(this);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	// Setup components
	private void setComponents()
	{
		// Setup main panel
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.decode("0xF2F0F5"));
		add(panel);
		
		// Setup top panel
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		topPanel.setBackground(Color.decode("0xDEDCE0"));
		panel.add(topPanel, BorderLayout.NORTH);
		
		// Setup selected item label
		selItem = new JLabel("Select command word");
		selItem.setHorizontalAlignment(SwingConstants.CENTER);
		selItem.setFont(new Font("Ariel", Font.BOLD, 14));
		topPanel.add(selItem);
		
		// Setup item help selection panel
		JPanel itemPanel = new JPanel();
		itemPanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		itemPanel.setBackground(Color.decode("0xF2F0F5"));
		panel.add(itemPanel, BorderLayout.WEST);
		
		// Add item list
		items = new JList();
		items.setListData(Server.commands);
		items.setBackground(Color.decode("0xF2F0F5"));
		items.addListSelectionListener(this);
		itemPanel.add(items);
		
		// Setup centre panel
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		centerPanel.setBackground(Color.decode("0xF2F0F5"));
		panel.add(centerPanel, BorderLayout.CENTER);
		
		// Setup basic help description
		JTextArea basicHelp = new JTextArea(5, 25);
		basicHelp.setEditable(false);
		basicHelp.setWrapStyleWord(true);
		basicHelp.setLineWrap(true);
		basicHelp.setBackground(Color.decode("0xF2F0F5"));
		basicHelp.setFont(new Font("Ariel", Font.PLAIN, 12));
		basicHelp.setText("Commands are entered in the command box. "
				        + "To execute a command click 'Go!'. "
				        + "Commands have a minimum number of parameters "
				        + "that must be included. The command word is the "
				        + "first word. If the command has parameters they "
				        + "are followed by '-' per perameter. E.g. "
				        + "'command_word-perameter'. Command words are case-"
				        + "sensitive and spaces are only to be used in "
				        + "parameters.");
		centerPanel.add(basicHelp);
		
		// Setup description label
		description = new JLabel();
		description.setFont(new Font("Ariel", Font.PLAIN, 12));
		centerPanel.add(description);
		
		// Setup usage label
		usages = new JLabel();
		usages.setFont(new Font("Ariel", Font.PLAIN, 12));
		centerPanel.add(usages);
		
		// Setup parameter label
		selParam = new JLabel();
		selParam.setFont(new Font("Ariel", Font.PLAIN, 12));
		centerPanel.add(selParam);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int index = items.getSelectedIndex();
		if(index > -1)
		{
			// Set selected item properties
			selItem.setText(Server.commands[index]);
			description.setText(descriptions[index]);
			usages.setText(usage[index]);
			selParam.setText("This command takes " +
				String.valueOf(paramValues[index] + " parameter(s)"));
		}
	}
}






















