

public class myClass{

	public static void main(String args[]){
		
		mySecondClass member1 = new mySecondClass("Megan", "Fox");
		mySecondClass member2 = new mySecondClass("Woman", "Curry");
		mySecondClass member3 = new mySecondClass("Lindsey", "Lohan");
		
		System.out.println();
		System.out.println(member1.getFirst());
		System.out.println(member1.getLast());
		System.out.println(member1.getMembers());
		
		//Static variables are shared among all objects and can be
		//called without an object

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
   
   public String getFirst(){
	   return first;
   }
   
   public String getLast(){
	   return last;
   }
   
   public static int getMembers(){
	   return members;
   }
}
