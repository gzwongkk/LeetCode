package easy;

public class ValidPalindrome {

	/**
	 * Given a string, determine if it is a palindrome, considering only alphanumeric
	 * characters and ignoring cases. For example, 
	 * "A man, a plan, a canal: Panama" is a palindrome.
	 * "race a car" is not a palindrome.
	 */
	public static void main(String[] args) {
		System.out.println(isPalindrome("ppp"));
	}

	public static boolean isPalindrome(String s){
		int left = 0, right = s.length() - 1 ;
		while( left < right ){
			while( left < right && !Character.isLetterOrDigit(s.charAt(left))) ++left;
			while( right > left && !Character.isLetterOrDigit(s.charAt(right))) --right;
			if( Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)) ) return false;
			++left;
			--right;
		}
		return true;
	}
}
