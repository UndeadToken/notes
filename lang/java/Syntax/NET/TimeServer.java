package NET;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeServer extends Thread {
	private ServerSocket sock;
	
	public TimeServer() {
		super();
		
		try {
			sock = new ServerSocket(4415);
			System.out.println("TimeServer running ...");
		} catch(IOException e) {
			System.out.println("Error: Couldn't create socket.");
			System.exit(1);
		}
	}
	
	public void run() {
		Socket client = null;
		
		while(true) {
			if(sock == null) 
				return;
			
			try {
				client = sock.accept();
				BufferedOutputStream bos = new BufferedOutputStream(
						client.getOutputStream());
				
				PrintWriter os = new PrintWriter(bos, false);
				String outline;
				Date now = new Date();
				os.println(now);
				os.flush();
				
			} catch(IOException e) {
				System.out.println("Couldn't connect to client.");
				System.exit(1);
			}
		}
	}
	
	public static void main(String[] args) {
		TimeServer server = new TimeServer();
		server.start();
	}

}
