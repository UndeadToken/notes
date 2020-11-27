public class myClass {
	public static void main(String args[]){
		   
		  enemy NINJA = new ninja();
		  enemy NERD = new nerd();
		  
		  NINJA.attack();
		  NERD.attack();
		 
	   }
}

public class ninja extends enemy{
   public void attack(){
	   System.out.println("Ninja Chop!");
   }
}


public class nerd extends enemy{
	public void attack(){
		   System.out.println("Hack Hack Hack!");
	   }
}


abstract public class enemy {
	public abstract void attack();
	//Objects cannot be created from abstract classes.
	//An abstract class that is not inherited is useless!!!
}
