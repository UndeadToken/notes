package com.take.control.framework;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class Server implements Runnable {
	public static volatile ArrayList<Socket> clients;
	private static String[] commands = {
		"url", 
		"confirmDialog", 
		"inputDialog", 
		"inputDialogQ", 
		"messageDialog", 
		"warningDialog", 
		"optionDialog",
	};
	
	@Override
	public void run() {
		try {
			// Create non blocking server socket  channel
			ServerSocketChannel sockChannel = 
					ServerSocketChannel.open();
			sockChannel.configureBlocking(false);
			
			// Set host and port number
			InetSocketAddress server = new InetSocketAddress(
					"localhost", 2407);
			ServerSocket socket = sockChannel.socket();
			socket.bind(server);
			
			// Create selector and register it to channel
			Selector selector = Selector.open();
			sockChannel.register(selector, SelectionKey.OP_ACCEPT);
			
			// Instantiate clients container
			clients = new ArrayList<Socket>();
			
			// Log server status
			Display.log("Server started. Now hosting on " +
						socket.getInetAddress().getHostAddress() 
						+ ":" + socket.getLocalPort());
			
			// Loop forever, listening for client connections
			while(true) {
				try {
					Thread.sleep(1000);
				} catch(Exception e){};
				
				// Wait for a connection
				selector.select();
				
				// Get list of selection keys with pending events
				Set keys = selector.selectedKeys();
				Iterator it = keys.iterator();
				
				// Handle each key
				while(it.hasNext()) {
					
					// Get and remove key from iteration
					SelectionKey selKey = (SelectionKey) it.next();
					it.remove();
					if(selKey.isAcceptable()) {
						
						// Create client socket connection with the client
						ServerSocketChannel selChannel = (ServerSocketChannel) selKey.channel();
						ServerSocket selSocket = selChannel.socket();
						Socket client = selSocket.accept();
						
						// Add client
						synchronized(this) {
							clients.add(client);
						}
						
						// Log client connection
						Display.log("[Client connection made: " + 
							client.getLocalAddress().toString());
					}
				}
			}
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
	// Send command to client
	public static synchronized void sendCommand(String command)
	{
		// Get command words
		String[] parameters = command.split("-");
		
		// Get command parameters
		Vector<String> params = new Vector<String>();
		for(int i = 0; i<parameters.length; i++)
		{
			if(i > 0)
				params.add(parameters[i]);
		}
		
		// Check if command exists
		boolean exists = false;
		for(String c : commands)
		{
			if(c.equals(parameters[0]))
				exists = true;
		}
		
		if(!exists) { 
			Display.log("Un-recognised command: " +
					command);
			return; 
		}
		
		// Get class command exists in
		String clazz = null;
		String exten = "com.take.control.commands.";
		int minParams = 0;
		switch(parameters[0])
		{
			case "url":
				clazz = exten + "WEB";
				minParams = 1;
				break;
				
			case "confirmDialog":
				clazz = exten + "Prompt";
				minParams = 2;
				break;
				
			case "inputDialog":
				clazz = exten + "Prompt";
				minParams = 1;
				break;
				
			case "inputDialogQ":
				clazz = exten + "Prompt";
				minParams = 2;
				break;
				
			case "messageDialog":
				clazz = exten + "Prompt";
				minParams = 1;
				break;
				
			case "warningDialog":
				clazz = exten + "Prompt";
				minParams = 2;
				break;
				
			case "optionDialog":
				clazz = exten + "Prompt";
				minParams = 5;
				break;
				
			default:
				return;
		}
		
		// Check if sufficient parameters
		if(params.size() < minParams)
		{
			Display.log("(Insufficent parameters. " + minParams 
					+ " required. Params give: " + params.size() + ")");
			return;
		}
		
		// Create packet to send
		Packet packet = new Packet(parameters[0], params, clazz);
		
		try {
			// Loop through all clients
			for(int i = 0; i<clients.size(); i++)
			{
				// Get output stream
				OutputStream os = clients.get(i).getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
			
				// Send packet
				oos.writeObject(packet);
			
				// Cleanup resources
				oos.flush();
			}
		} catch (IOException e) {
			Display.log("[Unable to send process to client]" + e.getMessage());
		}
	}
}





