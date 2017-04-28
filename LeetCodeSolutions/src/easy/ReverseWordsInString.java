package easy;

public class ReverseWordsInString {
	/**
	 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving
	 * whitespace and initial word order.
	 **/
	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}

	public static String reverseWords(String s) {
		char[] str = s.toCharArray();
		int j = 0;
		for ( int i = 0; i < str.length; ++i ) {
			if ( str[i] == ' ' ) {
				reverse(str, j, i-1);
				j = i+1;
			}
		}
		reverse(str, j, str.length-1);
		return new String(str);
	}
	
	public static void reverse( char[] s, int l, int r ) {
		while ( l < r ) {
			char t = s[l];
			s[l] = s[r];
			s[r] = t;
			l++;
			r--;
		}
	}
}
