import java.util.StringTokenizer;

public class stringTokenizer {

	public static void main(String[] args) {
		StringTokenizer st1, st2;
		
		String myString = "Hello / world!";
		st1 = new StringTokenizer(myString);
		System.out.println(st1.nextToken());
		
		String myString2 = "Hello@ world!";
		st2 = new StringTokenizer(myString2, "@");
		System.out.println(st2.nextToken());

	}

}
