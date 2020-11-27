package com.take.control.framework;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	private static final String HOST = "localhost";
	private static final int PORT = 2407;
	
	public void connect() {
	    try
	    {
	    	// Connect to host
	    	InetAddress address = InetAddress.getByName(HOST);
    		Socket connection = new Socket(address, PORT);
    		
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
    	catch (Exception g) {
    		System.out.println(g.getMessage());
    	} 
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
}



