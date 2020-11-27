package com.take.control.framework;

public class Main {
	public static void main(String[] Args) {
		
		// Initialise display
		Display display = new Display();
		
		// Initialise & Start server
		Server server = new Server();
		server.run();
	}
}
