
public class myClass {
	public static void main(String args[]){
		createFile File = new createFile();
		
		File.openFile();
		File.readFile();
		File.closeFile();
		
	}
}


import java.io.*;
import java.lang.*;
import java.util.*;

public class createFile {
	private Scanner x;
	
	public void openFile(){
		try{
			x = new Scanner(new File("C:\\Users\\PC\\Desktop\\myFile.txt"));
		}
		catch(Exception e){
			System.out.print("Could not read file.");
		}
	}
	
	public void readFile(){
		while(x.hasNext()){
			String a = x.next();
			String b = x.next();
			String c = x.next();
			
			System.out.printf("%s %s %s\n", a, b, c);
		}
	}
	
	public void closeFile(){
		x.close();
	}
}
