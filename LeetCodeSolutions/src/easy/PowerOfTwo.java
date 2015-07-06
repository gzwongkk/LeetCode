package easy;

public class PowerOfTwo {
	
	/**
	 * Given an integer, write a function to determine if it is a power of two.
	 **/

	public static void main(String[] args) {
		int input = 2048;
		System.out.println(isPowerOfTwo(input));
	}

	/*
	 * Bitwise operation can be tricky. Since an integer being power of two must have only
	 * one 1 in its binary representation(2^0 = 1), n & n-1 can easily check this condition.
	 */
	public static boolean isPowerOfTwo(int n){
		return n > 0 && (n&(n-1)) == 0;
	}
}
