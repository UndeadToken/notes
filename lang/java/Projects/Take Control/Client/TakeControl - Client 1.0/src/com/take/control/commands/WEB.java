package com.take.control.commands;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Vector;

public class WEB {
	
	// Goto URL
	public void url(Vector<String> params)
	{
		try {
			Desktop.getDesktop().browse(new URL("http://" + params.get(0)).toURI());
		} catch (IOException | URISyntaxException e) {}
	}
}
