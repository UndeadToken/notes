import java.util.*;


public class myClass {
	public static void main(String args[]){
		
		String[] stuff = {"APPLES", "beef", "corn", "ham"};
		List<String> list1 = Arrays.asList(stuff);
		
        ArrayList<String> list2 = new ArrayList();
        list2.add("youtube");
        list2.add("Google");
        list2.add("piratebay");
        
        for(String x : list2)
        	System.out.printf("%s ", x);
        
        Collections.addAll(list2, stuff);
        System.out.println();
        
        for(String x : list2)
        	System.out.printf("%s ", x);
        
        System.out.println(Collections.frequency(list2, "piratebay"));
        
        boolean tof = Collections.disjoint(list1, list2);
        System.out.println(tof);
        
        if(tof)
        	System.out.println("These elemenst do not have anything in comon");
        else
        	System.out.println("These lists have something in common.");
        	
	}
}
