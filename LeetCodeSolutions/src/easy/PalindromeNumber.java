package easy;

public class PalindromeNumber {

	/*
	 * Determine whether an integer is a palindrome. Do this without extra space.
	 */
	public static void main(String[] args) {
		int input = 1234321;
		System.out.println(isPalindrome(input));
	}

	/*
	 * Check equality of its reverse, overflow is automatically handled.
	 */
	public static boolean isPalindrome(int x){
		if( x < 0 ) return false;
		//return ReverseInteger.reverse(x)==x;
		int reverse = 0, original = x;
		while( x > 0 ){
			reverse = reverse * 10 + x % 10;
			x /= 10;
		}
		return reverse == original;
	}
}
