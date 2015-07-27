package medium;

public class MaximumProductSubarray {

	/**
	 * Find the contiguous sub-array within an array (containing at least one number) 
	 * which has the largest product. For example, given the array [2,3,-2,4],
	 * the contiguous sub-array [2,3] has the largest product = 6. 
	 **/
	public static void main(String[] args) {
		int[] nums = new int[]{	2, 3, -2, 4 };
		System.out.println(maxProdcut(nums));
	}

	/*
	 * My attempt was that the pattern for the array can be classified into "Left n Max n Right",
	 * having n represents negative elements. A few intuitive cases can be come up with, but this
	 * does not work when zero occurs.
	 * Remark: there is an online solution in this approach and it handles zeroes well. It further
	 * generalized the pattern into "Left n Right".
	 * 
	 * Like the "maximum sum of contiguous sub-array" problem, it is not necessary to use DP after
	 * looking deep to the nature of contiguous. Keeping the local max product can generate global
	 * max because of the property of multiplication. Also, local min product should be stored
	 * because when integers interact with negative, the largest become smallest and vice versa.
	 */
	public static int maxProdcut(int[] nums){
		int max = nums[0], localMax = nums[0], localMin = nums[0];
		for( int i = 1; i < nums.length; ++i ){
			if( nums[i] < 0 ){
				int temp = localMax;
				localMax = localMin;
				localMin = temp;
			}
			localMax = Math.max(nums[i], localMax*nums[i]);
			localMin = Math.min(nums[i], localMin*nums[i]);
			max 	 = Math.max(max, localMax);
		}
		return max;
	}
	
	public static int maxProductAttempt(int[] nums){
		int max = Integer.MIN_VALUE, front = 1, back = 1;
		for( int i = 0; i < nums.length; ++i ){
			front *= nums[i];
			back *= nums[nums.length-1 - i];
			max = Math.max(max, Math.max(front, back));
			front = front == 0? 1: front;
			back  = back  == 0? 1: back ;
		}
		return max;
	}
}
