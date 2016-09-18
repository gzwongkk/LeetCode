package easy;

public class PowerOfThree {
	/**
	 * Given an integer, write a function to determine if it is a power of three.
	 **/
	public static void main(String[] args) {
		for ( int i = 0; i < 10000000; i *= 3 )
			System.out.println(isPowerOfThree(i));
	}

	/*
	 * Since powers of three modulus 3 must be 0, if we take the max boundary 
	 * modulus any power of three, we should also get 0.
	 */
	public static boolean isPowerOfThree(int n){
		return (n > 0) && ( 1162261467 % n == 0 );
	}
}
