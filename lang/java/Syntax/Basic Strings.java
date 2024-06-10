import javax.swing.*;
import java.awt.*;

public class myClass {
	public static void main(String args[]){		
		
		String a= "apples";
		String b = "Apples";
		String c = "APPLES";
		
		if(a.equals("apples")){
			System.out.println(a.length());
		}
		
		if(b.equalsIgnoreCase(c)){
			System.out.println(a.length());
		}
	}
}
