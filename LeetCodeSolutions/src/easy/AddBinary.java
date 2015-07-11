package easy;

public class AddBinary {

	/**
	 * Given two binary strings, return their sum ( also a binary string ).
	 * For example,
	 * a = "11"
	 * b = "1"
	 * Return "100".
	 */
	public static void main( String[] args ) {
		String a = "110001", b = "100110101001";
		System.out.println(addBinary( a, b ));
	}

	/*
	 * Try using StringBuilder. It is very powerful with the reverse function, which saves
	 * me the use of stack. The exclusive or operator is also a highlight of this solution.
	 */
	public static String addBinary(String a, String b){
		int i = a.length()-1, j = b.length()-1;
		if( i == -1 ) return b;
		if( j == -1 ) return a;
		StringBuilder ans = new StringBuilder();
		int carry = 0, aBit, bBit;
		
		while( i > -1 || j > -1 || carry == 1 ){
			aBit = i > -1 ? a.charAt(i--)-'0': 0;
			bBit = j > -1 ? b.charAt(j--)-'0': 0;
			ans.append( aBit ^ bBit ^ carry );
			carry = (aBit + bBit + carry) >= 2 ? 1 : 0;
		}
		return ans.reverse().toString();
	}
}
