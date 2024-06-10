public class myClass {
	public static void main(String args[]){
		   
		   player PObject = new player();
		   enemy EObject = new enemy();
		   enemy NObject = new nerd();
		   enemy NJObject = new ninja();
		   
		   PObject.call_attack(NObject);
		   PObject.call_attack(NJObject);
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

public class player {
   
	 public void call_attack(enemy x ){
		 x.attack();
	 }
}
