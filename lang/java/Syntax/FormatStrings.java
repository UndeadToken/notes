
public class FormatStrings {

	public static void main(String[] args) {
		int accountBalance = 5005;
		System.out.format("Balance: £%,d %n", accountBalance);
		// %, d - groups every set of 3 digit using ','
		//%n newline
		
		//Format pi to 11 decimal places
		double pi = Math.PI;
		System.out.format("%.11f%ns", pi);
	}

}
