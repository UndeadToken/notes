package com.take.control.commands;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.take.control.framework.Client;

public class Graphic {
	
	// Display blank window
	public void blankWindow(Vector<String> params)
	{
		JFrame frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setAlwaysOnTop(true);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		frame.add(panel);
		
		Client.sendResponse("Display blank window: Success");
	}
	
	// Display image window
	public void imageWindow(Vector<String> params)
	{
		// Setup frame
		JFrame frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setAlwaysOnTop(true);
		frame.setUndecorated(true);
		
		// Get image
		Image image = null;
		try {
		    URL url = new URL(params.get(0));
		    image = ImageIO.read(url);
		} catch (IOException e) {
			Client.sendResponse("Display image window: Failed");
			return;
		}
		
		JLabel picLabel = new JLabel(new ImageIcon(image));
		picLabel.setSize(500,500);
		JPanel panel = new JPanel();
		panel.add(picLabel);
		frame.add(panel);

		frame.setVisible(true);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		
		frame.dispose();
		
		Client.sendResponse("Display image window: Success");
	}
}









