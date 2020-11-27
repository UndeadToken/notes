import java.util.*;

public class myClass {
	public static void main(String args[]){		
		Scanner input = new Scanner(System.in);
		int x = 0;
		
		do{
		   try{
		      System.out.print("Enter integer: ");
		      int n1 = input.nextInt();
		      System.out.print("Enter integer: ");
		      int n2 = input.nextInt();
		      int sum = n1/n2;
		      System.out.print(sum);
		      
		      x=1;
		}
		catch(Exception e){
			System.out.println("Invalid entry");
		}
		   
		}while(x == 0);
	}
}
