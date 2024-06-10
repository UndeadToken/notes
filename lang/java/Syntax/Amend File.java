
public class myClass {
	public static void main(String args[]){
		createFile file = new createFile();
		
		file.openFile();
		file.addRecords();
		file.closeFile();
	}
}

import java.io.*;
import java.lang.*;
import java.util.*;

public class createFile {

	private Formatter x;
	
	public void openFile(){
	   try{
		   x = new Formatter("myFile.txt");
	   }
	   catch(Exception e){
		   System.out.println("Could not create file...");
	   }
	}
	
	public void addRecords(){
		x.format("%s%s%s", "lewis ", "Tucker", "18");
	}
	
	public void closeFile(){
		x.close();
	}
}
