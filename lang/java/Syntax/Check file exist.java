import java.io.File;

public class myClass {
	public static void main(String args[]){
		   
		//Check file exists
		File x = new File("file path");
		
		if(x.exists())
			System.out.println(x.getName() + " does exist!");
		else
			System.out.println(x.getName() + " does not exist!");
		   
    }
}
