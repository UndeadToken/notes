public class myClass {
	public static void main(String args[]){		
		
		String a = "    Beans   ";
		String b = "    Bacon   ";
		
		//Concatenation
		System.out.println(a + b);
		System.out.println(a.concat(b));
		
		
		//Replace
		System.out.println(a.concat(b.replace('B', 'F')));
		
		//To Upper & Lower Case
		System.out.println(a.toUpperCase());//upper
		System.out.println(a.toLowerCase());//lower
		
		//Trim
		System.out.println(a.trim() + b.trim());
	}
}