
public class myClass{

	public static void main(String args[]){
		
		mySecondClass MSC = new mySecondClass(10);
		
		for(int c=0; c<5; c++){
			MSC.add();
			System.out.printf("%s", MSC);
		}

	}
}

public class mySecondClass {
	
   private int sum;
   private final int NUMBER;
   
   public mySecondClass(int x){   
	   NUMBER=x;
   }
   
   public void add(){
	   sum+=NUMBER;
   }
   
   public String toString(){
	   return String.format("sum = %d\n", sum);
   }
}
