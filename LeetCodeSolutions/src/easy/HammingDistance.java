package easy;

public class HammingDistance {
	/**
	 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
	 * Given two integers x and y, calculate the Hamming distance.
	 * Note:
	 * 0 <= x, y < 2^31
	 * 
	 * Example:
	 * Input: x = 1, y = 4
	 * Output: 2
	 * Explanation:
	 * 1   (0 0 0 1)
	 * 4   (0 1 0 0)
	 * 		  ¡ô   ¡ô
	 **/
	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
		System.out.println(hammingDistance(1, 2));
		System.out.println(hammingDistance(93, 73));
	}

	/*
	 * Exclusive OR turns the different bits into 1. Counting the 1s is then the Hamming distance. 
	 */

	public static int hammingDistance(int x, int y) {
		int d = 0, bits = x^y;
		while ( bits != 0 ) {
			d += bits&1;
			bits >>= 1;
		}
		return d;
	}
}
