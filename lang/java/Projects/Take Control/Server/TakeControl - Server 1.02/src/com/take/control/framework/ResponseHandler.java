package com.take.control.framework;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ResponseHandler implements Runnable {

	// Attempt to get user responses
	public void run() {
		
		while(true)
		{
			// Collect responses every 5 seconds
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {}
			
			// Get response from all clients
			for(Socket client : Server.clients)
			{
				try {
					// Get input stream
					ObjectInputStream ois = new ObjectInputStream(
							client.getInputStream());
					
					// Get response packet
					Object o = ois.readObject();
					ResponsePacket packet = (ResponsePacket) o;
							
					// Log user response
					Display.log("(" + packet.response + ")");
					
					
				} catch (IOException | ClassNotFoundException e) {}
			}
		}
	}
}
