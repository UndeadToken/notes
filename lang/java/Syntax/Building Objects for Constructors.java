public class myClass{
	public static void main(String args[]){
		
		mySecondClass MSC = new mySecondClass();
		mySecondClass MSC2 = new mySecondClass(5);
		mySecondClass MSC3 = new mySecondClass(5,13);
		mySecondClass MSC4 = new mySecondClass(5,13,43);
		
		System.out.printf("%s\n", MSC.toMilitary());
		System.out.printf("%s\n", MSC2.toMilitary());
		System.out.printf("%s\n", MSC3.toMilitary());
		System.out.printf("%s\n", MSC4.toMilitary());
		
	}
}

public class mySecondClass {
	
   private int hour;
   private int minute; 
   private int second;	

   public mySecondClass(){
	   this(0,0,0);
   }
   
   public mySecondClass(int h){
	   this(h,0,0);
   }
   
   public mySecondClass(int h, int m){
	   this(h,m,0);
   }
   
   public mySecondClass(int h, int m, int s){
	   setTime(h,m,s);
   }
   
   public void setTime(int h, int m, int s){
	   
	   setHour(h);
	   setMinute(m);
	   setSecond(s);
   }
   
   //Set Method
   public void setHour(int h){   
	   hour = ((h>=0&&h<24)?h:0);
   }
   
   public void setMinute(int m){   
	   minute = ((m>=0&&m<24)?m:0);
   }
   
   public void setSecond(int s){   
	   second = ((s>=0&&s<24)?s:0);
   }
   
   //Get Method
   public int getHour(){
	   return hour;
   }
   
   public int getMinute(){
	   return minute;
   }
   
   public int getSecond(){
	   return second;
   }
   
   public String toMilitary(){
	   return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());	   
   }
   
}