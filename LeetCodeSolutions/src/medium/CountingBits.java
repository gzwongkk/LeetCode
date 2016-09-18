package medium;

public class CountingBits {
	/**
	 * Given a non negative integer number num. For every numbers i in the range 0 <= i <= num calculate the number
	 * of 1's in their binary representation and return them as an array.
	 * 
	 * Example: For num = 5 you should return [0,1,1,2,1,2].
	 * 
	 * It is very easy to come up with a solution with run time O(n*sizeof(integer)) but can it be O(n) in a single apss?
	 * Space should be O(n)
	 **/
	public static void main(String[] args) {
		for ( int i : countBits(5) )
			System.out.println(i);
	}

	/*
	 * An intuitive solution can be built similar to Grey code. Otherwise, a recursive approach also works.
	 */
	public static int[] countBits(int num) {
		int[] ans = new int[num+1];
		
		for ( int i = 1, k = 2; i <= num; i <<= 1, k <<= 1 ) {
			for ( int j = i; j < k && j <= num; ++j ) {
				ans[j] = 1 + ans[j-i];
			}
		}
		
		return ans;
	}
	
	public static int[] countBitsRecursive(int num) {
		int[] ans = new int[num+1];
		for ( int i = 1; i <= num; ++i )
			ans[i] = ans[i>>1] + (i&1);
		return ans;
	}
}
