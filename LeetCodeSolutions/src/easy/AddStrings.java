package easy;

public class AddStrings {
	/**
	 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
	 * 
	 * Note:
	 * 
	 * The length of both num1 and num2 is < 5100.
	 * Both num1 and num2 contains only digits 0-9.
	 * Both num1 and num2 does not contain any leading zero.
	 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
	 **/
	public static void main(String[] args) {
		System.out.println(addStrings("32169", "651"));
	}

	//Trivial
	public static String addStrings(String num1, String num2) {
		char[] a = num1.toCharArray();
		char[] b = num2.toCharArray();
		StringBuilder sum = new StringBuilder();
		
		int carry = 0;
		for ( int i = a.length-1, j = b.length-1; i >= 0 || j >= 0 || carry != 0; --i, --j ) {
			int x = i < 0? 0: a[i]-'0';
			int y = j < 0? 0: b[j]-'0';
			sum.append((x+y+carry)%10);
			carry = (x+y+carry) >= 10? 1: 0;
		}
		
		return sum.reverse().toString();
	}
}
