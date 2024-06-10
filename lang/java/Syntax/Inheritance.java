
public class myClass {

	public static void main(String args[]){
		
		mySecondClass MSC = new mySecondClass();
		potpie PO = new potpie();
		
		MSC.attack();
		PO.attack();

	}
}

public class mySecondClass extends enemy{
	
}


public class potpie extends enemy{


}


public class enemy {
   public void attack(){
	   
	   System.out.println("I can attack!!!\n");
   }
}
