package medium;

public class SingleNumberIII {
	/**
	 * Given an array of numbers nums, in which exactly two elements appear only once and all
	 * the other elements appear exactly twice. Find the two elements that appear only once.
	 * For example: Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
	 * Note:
	 * 1. The order of the result is not important. So in the above example, [5, 3] is also correct.
	 * 2. Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
	 **/
	public static void main(String[] args) {
		int[] ans = singleNumber(new int[]{1,2,1,3,2,5});
		System.out.println(ans[0] + " " + ans[1]);
	}

	/*
	 * Begin with relaxing the problem, consider how to separate A^B into A and B.
	 * Since the two number is different and the result of exclusive or means that only one
	 * element has a one on that bit, thus we can divide the whole array into two groups according to that bit, 
	 * and become the same as finding one single number from an array with other elements
	 * appear exactly twice. 
	 * A & -A == A & !(A-1) this finds the least significant difference.
	 */
	public static int[] singleNumber(int[] nums){
		int xor = 0;
		int[] ans = new int[2];
		for( int n : nums ) xor ^= n;
		xor &= -xor;
		for( int n : nums ){
			if( (n & xor) == 0 ) ans[0] ^= n;
			else ans[1] ^= n;
		}
		return ans;
	}
}
