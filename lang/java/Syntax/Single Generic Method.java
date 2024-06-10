import java.util.*;


public class myClass {
	public static void main(String args[]){
		
        Integer[] iray = {1,2,3,4,5};
        Character[] cray = {'a', 'b', 'c', 'd', 'e'};
        
        printMe(iray);
        printMe(cray);
    }
	
	public static <T> void printMe(T[] x){
		for(T b : x)
			System.out.printf("%s", b);
		System.out.println();
	}
}
