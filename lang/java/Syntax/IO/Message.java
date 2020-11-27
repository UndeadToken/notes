package IO;
import java.io.Serializable;
import java.util.Date;


public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	
	transient String uselessString = "cake"; // Variable that is excluded from object file when serialised
	int lineCount;
	String from, to;
	Date when;
	String[] text;
	
	void writeMessage(String inFrom,
			String inTo,
			Date inWhen,
			String[] inText) 
	{
		text = new String[inText.length];
		for(int i =0; i < inText.length; i++) 
			text[i] = inText[i];
		lineCount = inText.length;
		to = inTo;
		from = inFrom;
		when = inWhen;
	}
}
