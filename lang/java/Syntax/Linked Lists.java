import java.util.*;


public class myClass {
	public static void main(String args[]){		
		
		String[] things = {"apples", "noobs", "Ponage", "Bacon", "Goats"};
		List<String> list1 = new LinkedList();
		
		for(String x : things)
			list1.add(x);
		
		String[] things2 = {"sausage", "bacon", "goats", "harrypotter"};
		List<String> list2 = new LinkedList();
		
		for(String y : things2)
			list2.add(y);
		
		list2.addAll(list2);
		list2 = null;
		
		printMe(list1);
		removeStuff(list1, 2, 5);
		printMe(list1);
		reverseMe(list1);
	}
	
	//print me method
	private static void printMe(List<String> l){
		for(String b : l)
			System.out.printf("%s", b);
	}
	
	//remove stuff method
	public static void removeStuff(List<String> l, int from, int to){
		l.subList(from, to).clear();
	}
	
	//reverse me method
    private static void reverseMe(List<String> l){
		ListIterator<String> bobby = l.listIterator(l.size());
		while(bobby.hasPrevious())
			System.out.printf("%s\n", bobby.previous());
	}
}
