
public class myClass{

	public static void main(String args[]){
		
		mySecondClass member1 = new mySecondClass("Megan", "Fox");
		mySecondClass member2 = new mySecondClass("Woman", "Curry");
		mySecondClass member3 = new mySecondClass("Lindsey", "Lohan");
	}
}

public class mySecondClass {
	
   private String first;
   private String last;
  
   private static int members = 0;
   
   public mySecondClass(String fn, String ln){
	   
	   first = fn;
	   last = ln;
	   members++;
	   
	   System.out.printf("Constructor for %s %s, members in the club: %d\n", last, first, members);
   }
}
