package com.take.control.framework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Display extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static JTextArea log;
	private static JTextField commandBox;
	private static JButton processCommand;
	
	// Initialise display
	public Display()
	{
		setTitle("TakeControl");
		setSize(350, 400);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLookAndFeel();
		setComponents();
		setVisible(true);
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
		// Setup top panel
		JPanel topPanel = new JPanel();
		topPanel.setBorder(new EmptyBorder(10, 0, 0, 10));
		add(topPanel, BorderLayout.NORTH);
		
		// Setup server description
		JLabel description = new JLabel("TakeControl Server 1.0");
		description.setHorizontalAlignment(SwingConstants.CENTER);
		topPanel.add(description);
		
		// Setup centre panel
		JPanel centrePanel = new JPanel();
		centrePanel.setBorder(new EmptyBorder(5, 5, 0, 5));
		add(centrePanel, BorderLayout.CENTER);
		
		// Setup log box
		log = new JTextArea(15, 35);
		log.setEditable(false);
		log.setWrapStyleWord(true);
		log.setFont(new Font("Ariel", Font.PLAIN, 10));
		JScrollPane scrollPane = new JScrollPane(log, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		centrePanel.add(scrollPane);
		
		// Setup bottom panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		bottomPanel.setLayout(new FlowLayout());
		add(bottomPanel, BorderLayout.SOUTH);
		
		// Setup command box
		commandBox = new JTextField(27);
		bottomPanel.add(commandBox);
		
		// Setup process command button
		processCommand = new JButton("GO!");
		processCommand.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				log("Processing command: " + commandBox.getText());
				Server.sendCommand(commandBox.getText());
				commandBox.setText("");
			}
		});
		bottomPanel.add(processCommand);
		pack();
		
		// Setup quit button
		JButton stop = new JButton("Stop");
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Server.stop();
				System.exit(0);
			}
		});
		bottomPanel.add(stop);
	}
	
	// Add log entry
	public static void log(String text)
	{
		log.append(text + System.lineSeparator());
	}
	
	// Clear log
	public static void clearLog()
	{
		log.setText("");
	}
}
