
public class myClass{
	public static void main(String args[]){
		
		mySecondClass MSC = new mySecondClass();
		System.out.println(MSC.displayTime()); //Display default time
		
		MSC.setTime(10, 5, 45); // set time
		
		System.out.println(MSC.displayTime()); // display new time
	}
}

public class mySecondClass {
	
   private int hour, minute, second;	
	
   public void setTime(int h, int m, int s){
	   
	  hour = ((h>0 && h<24) ? h : 0);
	  minute = ((m>0 && m<60) ? m : 0);
	  second = ((s>0 && s<60) ? s : 0);
   }
   
   public String displayTime(){
	   
	   return String.format("%02d:%02d:%02d", hour, minute, second);
   }
}

-------------------------------------------------------------------------

public class myClass{
	public static void main(String args[]){
		
		mySecondClass MSC = new mySecondClass();
		
		System.out.println(MSC.displayTime()); 
		System.out.println(MSC.toString()); //default time
		
		MSC.setTime(13, 45, 20); 
		
		System.out.println(MSC.displayTime()); 
		System.out.println(MSC.toString()); //set time
	}
}



public class mySecondClass {
	
   private int hour, minute, second;	
	
   public void setTime(int h, int m, int s){
	   
	  hour = ((h>0 && h<24) ? h : 0);
	  minute = ((m>0 && m<60) ? m : 0);
	  second = ((s>0 && s<60) ? s : 0);
   }
   
   public String displayTime(){
	   
	   return String.format("%02d:%02d:%02d", hour, minute, second);
   }
   
   public String toString(){
	   
	   return String.format("%d: %02d: %02d: %s", ((hour==0 || hour==12) ?12:hour%12), minute, second, (hour<12? "AM":"PM"));
   }
}
