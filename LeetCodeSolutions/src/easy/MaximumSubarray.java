package easy;

public class MaximumSubarray {
	/**
	 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
	 * 
	 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
	 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
	 **/
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
	}

	// Dynamic programming
	public static int maxSubArray(int[] nums) {
		if ( nums.length == 0 ) return 0;
		int max = nums[0], maxsum = nums[0];
		for ( int i = 1; i < nums.length; ++i ) {
			maxsum = Math.max(maxsum+nums[i], nums[i]);
			max = Math.max(maxsum, max);
		}
		return max;
	}
}
