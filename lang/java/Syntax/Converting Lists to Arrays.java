import java.util.*;


public class myClass {
	public static void main(String args[]){		
		
      String[] stuff = {"melons", "fudge", "cheese", "ham"};
      LinkedList<String> theList = new LinkedList<String>(Arrays.asList(stuff));
      
      theList.add("pumpkin");
      theList.addFirst("Firstthing");
      
      stuff = theList.toArray(new String[theList.size()]);
      
      for(String x : stuff)
    	  System.out.printf("%s", x);
		
	}
}
