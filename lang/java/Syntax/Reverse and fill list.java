import java.util.*;


public class myClass {
	public static void main(String args[]){		
		
     Character[] ray = {'p', 'w', 'n'};
     List<Character> l = Arrays.asList(ray);
     
     System.out.println("List is: ");
     output(l);
     
     //Reverse list
     Collections.reverse(l);
     
     System.out.println("After reverse: ");
     output(l);
     
     //Create new array and new list
     Character[] newRay = new Character[3];
     List<Character> listcopy = Arrays.asList(newRay);
     
     //Copy contents of list to another list
     Collections.copy(listcopy, l);
	 System.out.println("Copy of list: ");
	 output(listcopy);
	 
	 //collection with crap
	 Collections.fill(l, 'X');
	 System.out.println("After filling list: ");
	 output(l);
	}
	
	private static void output(List<Character> theList){
		for(Character thing : theList)
			System.out.printf("%s", thing);
		
		System.out.println();
	}
}
