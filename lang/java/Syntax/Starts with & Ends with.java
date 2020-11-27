import javax.swing.*;
import java.awt.*;

public class myClass {
	public static void main(String args[]){		
		
		String[] words = {"funk", "chunk", "furry", "baconator"};
		
		//Starts with
		for(String w : words){
			if(w.startsWith("fu"))
				System.out.println(w + " starts with fu");
		}	
		
		//ends with
				for(String w : words){
					if(w.endsWith("unk"))
						System.out.println(w + " ends with unk");
				}	
	}
}
