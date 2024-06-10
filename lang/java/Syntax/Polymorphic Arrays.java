
public class myClass {
	public static void main(String args[]){
		   
		   enemy EObject[] = new enemy[2];
		   EObject[0] = new ninja();
		   EObject[1] = new nerd();
		   
		   for(int x=0;x<EObject.length;x++)
		      EObject[x].attack();
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

public class enemy {
	public void attack(){}
}
