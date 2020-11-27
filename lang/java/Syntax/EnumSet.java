import java.util.EnumSet;

public class myClass{

	public static void main(String args[]){
		
		for(mySecondClass people: mySecondClass.values())
			System.out.printf("%s\t%s\t%s\n", people, people.getDesc(), people.getYear());
		
		    System.out.println("\nAnd now for the range of constants!!!\n");
		    
		    for(mySecondClass people: EnumSet.range(mySecondClass.gary, mySecondClass.darren))
		    	System.out.printf("%s\t%s\t%s\n", people, people.getDesc(), people.getYear());
	}
}


public enum mySecondClass {
	
   pop("big", "12"),
   gary("homeless", "54"),
   darren("lazy","567"),
   ;
   
   private final String desc;
   private final String year;
   
   mySecondClass(String description, String birthday){
	   
	   desc = description;
	   year = birthday;
   }
   
   public String getDesc(){
	   return desc;
   }
   
   public String getYear(){
	   return year;
   }
  
}
