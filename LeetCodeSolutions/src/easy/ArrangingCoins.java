package easy;

public class ArrangingCoins {
	/**
	 * You have a total of n coins that you want to form in a staircase shape, 
	 * where every k-th row must have exactly k coins.
	 * 
	 * Given n, find the total number of full staircase rows that can be formed.
	 * 
	 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
	 * 
	 * Example 1:
	 * 
	 * n = 5
	 * The coins can form the following rows:
	 * ¤
	 * ¤ ¤
	 * ¤ ¤
	 * Because the 3rd row is incomplete, we return 2.
	 * 
	 * Example 2:
	 * n = 8
	 * 
	 * The coins can form the following rows:
	 * ¤
	 * ¤ ¤
	 * ¤ ¤ ¤
	 * ¤ ¤
	 * Because the 4th row is incomplete, we return 3.
	 **/
	public static void main(String[] args) {
		System.out.println(arrangeCoins(1));
		System.out.println(arrangeCoins(4));
		System.out.println(arrangeCoins(5));
		System.out.println(arrangeCoins(8));
		System.out.println(arrangeCoins(500));
		System.out.println(arrangeCoins(800));
		System.out.println(arrangeCoins(1804289383));
	}

	/*
	 * 1. Trivial ~71ms
	 * 2. Gauss summation ~45ms
	 */
	public static int arrangeCoins(int n) {
		return arrangeCoinsGauss(n);
	}
	
	public static int arrangeCoinsTrivial(int n) {
		int ans = 0;
		while ( n - ans - 1 >= 0 ) {
			n -= ++ans;
		}
		return ans;
	}
	
	public static int arrangeCoinsGauss(int n) {
		long num = n;
		long ans = (long) Math.sqrt(num<<1);
		long sum = ( ans * (ans + 1)) >> 1; 
		return ( num >= sum )? (int)ans: (int)ans-1;
	}
	
	public static int arrangeCoinsGaussQuadratic(int n) {
		return (int) (-1.0+Math.sqrt(1+(((long) n)<<3))/2.0);
	}
}
