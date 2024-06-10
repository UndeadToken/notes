public class myClass{

	public static void main(String args[]){
		
		for(mySecondClass people: mySecondClass.values())
			System.out.printf("%s\t%s\t%s\n", people, people.getDesc(), people.getYear());
	}
}


public enum mySecondClass {
	
   nigg("big", "12"),
   gary("homeless", "54"),
   darren("niggerish","567");
   
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
