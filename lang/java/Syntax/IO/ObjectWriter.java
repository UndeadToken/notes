package IO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;


public class ObjectWriter {
	public static void main(String[] args) {
		Message mess = new Message();
		String author = "Sam Wainwright, London";
		String recipient = "George Bailey, Bedford Falls";
		String[] letter = {"Mr. Gower cabled you need cash. Stop.",
				"My office instructed to advanced you up to twnty-five",
				"thousand dollars. Stop. Hee-haw and Merry Christmas."};
		
		Date now = new Date();
		mess.writeMessage(author, recipient, now, letter);
		try {
			FileOutputStream fo = new FileOutputStream("Message.obj");
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			oo.writeObject(mess);
			oo.close();
		} catch(IOException e) {
			System.out.println("Error -- " + e.toString());
		}
	}
}
