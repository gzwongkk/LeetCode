package medium;

public class MissingNumber {
	/**
	 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one
	 * that is missing from the array.
	 * For example, Given nums = [0, 1, 3] return 2.
	 * 
	 * Note:
	 * Your algorithm should run in linear runtime complexity. Could you implement it using only
	 * constant extra space complexity?
	 **/
	public static void main(String[] args) {
		System.out.println(missingNumber(new int[]{0,1,3,4,5,6}));
	}

	/*
	 * This is an extremely interesting problem because we can use the simple n*(n+1)/2 to solve,
	 * and also the XOR operator. Remember once again, O(n)time O(1)space requires simple operation only.
	 */
	public static int missingNumber(int[] nums){
		int missing = nums.length;
		for( int i = 0; i < nums.length; ++i )
			missing = missing ^ i ^ nums[i];
		return missing;
	}
	
	public static int missingNumberFixOverflow(int[] nums){
		int sum = 0;
		for( int i = 0; i < nums.length; ++i )
			sum += nums[i];
		return (nums.length*(nums.length+1) - (sum << 1)) >> 1;
	}
	
	public static int missingNumberOverflow(int[] nums){
		int sum = 0;
		for( int i = 0; i < nums.length; ++i )
			sum += nums[i];
		return (nums.length*(nums.length+1)>>1)-sum;
	}
}
