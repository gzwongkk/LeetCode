package easy;

public class ReverseString {
	/**
	 * Write a function that takes a string as input and returns the string reversed.
	 * Given s = "hello", return "olleh".
	 **/
	public static void main(String[] args) {
		System.out.println(reverseString("hello"));
		System.out.println(reverseStringNew("hellonew"));
	}

	/*
	 * 1.	Use the native string builder's reverse function
	 * 2.	Use swaps to achieve reverse
	 */
	public static String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
	}
	
	public static String reverseStringNew(String s) {
		char[] c = s.toCharArray();
		int n = c.length-1, n2 = n >> 1;
		for ( int i = 0; i <= n2; ++i ){
			char cs = c[i];
			c[i] = c[n-i];
			c[n-i] = cs;
		}
		return new String(c);
	}
}
