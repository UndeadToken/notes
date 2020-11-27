package NET;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class FingerServer {
	
	public void FingerServer() {
		try {
			// Create non blocking server socket  channel
			ServerSocketChannel sockChannel = 
					ServerSocketChannel.open();
			sockChannel.configureBlocking(false);
			
			// Set host and port number
			InetSocketAddress server = new InetSocketAddress(
					"localhost", 79);
			ServerSocket socket = sockChannel.socket();
			socket.bind(server);
			
			// Create selecteor and register it to channel
			Selector selector = Selector.open();
			sockChannel.register(selector, SelectionKey.OP_ACCEPT);
			
			// Loop forever, listening for client connections
			while(true) {
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
						Socket connection = selSocket.accept();
						
						// Handle Finger request
						handleRequest(connection);
						connection.close();
					}
				}
			}
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
	private void handleRequest(Socket connection) throws IOException {
		
		// Set up input and output
		InputStreamReader isr = new InputStreamReader (
				connection.getInputStream());
		
		BufferedReader is = new BufferedReader(isr);
		PrintWriter pw = new PrintWriter(new 
				BufferedOutputStream(connection.getOutputStream()),
				false);
		
		// Output server greeting
		pw.println("Nio Finger Server");
		pw.flush();
		
		// handle user input
		String outLine = null;
		String inLine = is.readLine();
		
		if(inLine.length() > 0) {
			outLine = inLine;
		}
		readPlan(outLine, pw);
		
		// Clean up
		pw.flush();
		pw.close();
		is.close();
	}
	
	private void readPlan(String userName, PrintWriter pw) {
		try {
			FileReader file = new FileReader(userName + ".plan");
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			
			pw.println("\nUser name: " + userName + "\n");
			
			while(!eof) {
				String line = buff.readLine();
				
				if(line == null) {
					eof = true;
				} else {
					pw.println(line);
				}
			}
			
			buff.close();
		} catch(IOException ioe) {
			pw.println("User " + userName + " not found.");
		}
	}
	
	public static void main(String[] args) {
		new FingerServer();
	}

}
