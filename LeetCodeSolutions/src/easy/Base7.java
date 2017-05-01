package easy;

public class Base7 {
	/**
	 * Given an integer, return its base 7 string representation.
	 **/
	public static void main(String[] args) {
		System.out.println(convertToBase7(100));
		System.out.println(convertToBase7(-7));
	}

	// Trivial
	public static String convertToBase7(int num) {
		if ( num < 0 ) return "-" + convertToBase7(-num);
		if ( num == 0 ) return "0";
		
		StringBuilder n = new StringBuilder();
		
		while ( num > 0 ) {
			n.append(num%7);
			num /= 7;
		}
		
		return n.reverse().toString();
	}
}
