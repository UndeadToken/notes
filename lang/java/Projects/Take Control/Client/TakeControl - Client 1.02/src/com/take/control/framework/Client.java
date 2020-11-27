package com.take.control.framework;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	private static final String HOST = "localhost";
	private static final int PORT = 2407;
	public static Socket connection;
	
	public void connect() {
	    try
	    {
	    	// Connect to host
	    	InetAddress address = InetAddress.getByName(HOST);
	    	
	    	// Attempt to connect to server
	    	while(true)
	    	{
	    		try {
	    			Thread.sleep(5000);
	    			connection = new Socket(address, PORT);
	    			break;
	    		}catch(Exception e){}
	    	}
    		 
    		boolean running = true;
    		
    		                                                                           
    		while(running)
    		{
    			// Get input stream
    			ObjectInputStream oi = new ObjectInputStream(
    						    connection.getInputStream());
    			
    			processCommand(oi.readObject());
    		}
    		connection.close();
	    }
    	catch (Exception g) {} 
	}
	
	// Process command
	private void processCommand(Object o)
	{
		if(o != null)
		{
			Packet packet = (Packet) o;
			
			try {
				// Get class
				Class<?> clazz = Class.forName(packet.clazz);

				// Get object reference
				Object object = clazz.newInstance();
				
				Method[] methods = clazz.getMethods();
				for (Method m : methods) {
					if (m.getName().equals(packet.command)) {
						  try {
						    Object result = m.invoke(object, packet.parameters);
						  } catch (Exception ex) {
							  ex.printStackTrace();
						  }
					}
				}
				
			} catch (ClassNotFoundException | SecurityException | 
					 InstantiationException | IllegalAccessException | 
					 IllegalArgumentException e) {
				e.printStackTrace();
			}  
		}
	}
	
	// Send user response to server
	public static void sendResponse(String response)
	{
		// Create response packet
		ResponsePacket packet = new ResponsePacket(response);
		
		try {
			// Get output stream
			ObjectOutputStream oos = new ObjectOutputStream(
					          connection.getOutputStream());
			
			// Send packet to server
			oos.writeObject(packet);
			oos.flush();
			
		} catch (IOException e) {}
	}
}









