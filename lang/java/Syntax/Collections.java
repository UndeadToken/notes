import java.util.*;


public class myClass {
	
	//main
	public static void main(String args[]){		
		
		String[] s = {"eggs", "lasers", "chocolate", "pie"};
		List<String> list1 = new ArrayList<String>();  
		
		//add items
		for(String x : s)
		   list1.add(x);
		
		String[] more = {"eggs", "pie"};
		List<String> list2 = new ArrayList<String>();
        
		//add more
		for(String y : more)
			list2.add(y);
		
		for(int i = 0; i<list1.size();i++){
			System.out.printf("%s", list1.get(i));
		}
		
		editList(list1, list2);
		System.out.println();
		
		for(int i = 0; i<list1.size();i++){
			System.out.printf("%s", list1.get(i));
		}
	}
	
	public static void editList(Collection<String> l1, Collection<String> l2){
		Iterator<String> it = l1.iterator();
		while(it.hasNext()){
			if(l2.contains(it.next()))
				it.remove();
		}
	}

}
