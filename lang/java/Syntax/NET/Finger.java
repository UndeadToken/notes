/*
 * FINGER: A protocol for asking a system about one of its users.
 */

package NET;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class Finger {
	public static void main(String[] args) {
		String user;
		String host;
		if((args.length == 1) && (args[0].indexOf("@") > -1)) {
			StringTokenizer split = new StringTokenizer(args[0], "@");
			user = split.nextToken();
			host = split.nextToken();
		} else {
			System.out.println("Usage: java Finger user@host");
			return;
		}
		
		try (Socket digit = new Socket(host, 79);
				BufferedReader in = new BufferedReader(
						new InputStreamReader(digit.getInputStream()));
				) 
		{
			digit.setSoTimeout(200000);
			PrintStream out = new PrintStream(digit.getOutputStream());
			out.print(user + "\015\012");
			
			boolean eof = false;
			while(!eof) {
				String line = in.readLine();
				if(line != null) {
					System.out.println(line);
				} else {
					eof = true;
				}
			}
			digit.close();
		} catch(IOException e) {
			System.out.println("IO Error: " + e.getMessage());
		}
	}
}
