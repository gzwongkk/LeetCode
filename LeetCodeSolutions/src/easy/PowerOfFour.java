package easy;

public class PowerOfFour {
	/**
	 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
	 * Given num = 16, return true. Give num = 5, return false.
	 * Could you solve it without loops/recursion?
	 **/
	public static void main(String[] args) {
		for ( int i = 1; i < 10000000; i*=4 ){
			System.out.println(isPowerOfFour(i));
			System.out.println(isPowerOfFour(i+1));
		}
	}

	/*
	 * Since a number which is power of four must also be power of two (4 = 2^2),
	 * we can utilise (n&(n-1)) == 0 to check if it is power of 2 first.
	 * Then we eliminate the cases that are power of 2 but not 4 by checking the bits at even position.
	 */
	public static boolean isPowerOfFour(int num){
		return num > 0 && ( (num & 0xAAAAAAAA) == 0 ) && ((num & num-1) == 0);
	}
}
