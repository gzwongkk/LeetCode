package easy;

public class LongestPalindrome {
	/**
	 * Given a string which consists of lowercase or uppercase letters, find the length of the longest 
	 * palindromes that can be built with those letters.
	 * 
	 * This is case sensitive, for example "Aa" is not considered a palindrome here.
	 * 
	 * Note:
	 * Assume the length of given string will not exceed 1,010.
	 **/
	public static void main(String[] args) {
		System.out.println(longestPalindrome("abccccdd"));
	}

	// Every pair of same letter must exist in the longest palindrome. Only one odd ones can only present.
	public static int longestPalindrome(String s) {
		boolean[] letters = new boolean[58];
		for ( char c : s.toCharArray() ) {
			letters[c-'A'] = !letters[c-'A'];
		}
		
		int odds = 0;
		for ( boolean b : letters ) // this loop is more superior than check during the pass if n > 59
			if ( b ) ++odds;
		return s.length() - (odds > 0? odds - 1: 0);
	}
}
