package easy;

public class NthDigit {
	/**
	 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
	 * 
	 * Note:
	 * n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).
	 **/
	public static void main(String[] args) {
		System.out.println(findNthDigit(3));
		System.out.println(findNthDigit(11));
		System.out.println(findNthDigit(189));
		System.out.println(findNthDigit(190));
	}

	/*
	 * It is similar to base conversion, which you have to figure out the level difference 
	 * and then reinterpret the original number.
	 */
	public static int findNthDigit(int n) {
		--n;
		int amount = 9, level = 1;
		
		while ( n / amount / level > 0 ) {
			n -= amount * level++;
			amount *= 10;
		}
		
		return (( amount / 9 ) + ( n / level ) + "").charAt( n % level ) - '0';
	}
}