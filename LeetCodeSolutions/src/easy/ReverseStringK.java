package easy;

public class ReverseStringK {
	/**
	 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters 
	 * counting from the start of the string. If there are less than k characters left, reverse all of them. 
	 * If there are less than 2k but greater than or equal to k characters, then reverse the first k characters 
	 * and left the other as original.
	 **/
	public static void main(String[] args) {
		System.out.println(reverseStr("abcdefg", 2));
	}

	// Trivial
	public static String reverseStr(String s, int k) {
		char[] str = s.toCharArray();
		
		for ( int i = 0; i < str.length; i += k << 1 ) {
			int a = i, b = i + k - 1;
			if ( b >= str.length ) b = str.length-1;
			
			while ( a < b ) {
				char t = str[a];
				str[a++] = str[b];
				str[b--] = t;
			}
		}
		
		return new String(str);
	}
}
