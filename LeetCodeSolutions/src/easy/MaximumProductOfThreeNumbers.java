package easy;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
	/**
	 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
	 * 
	 * Example 1:
	 * Input: [1,2,3]
	 * Output: 6
	 * Example 2:
	 * Input: [1,2,3,4]
	 * Output: 24
	 * Note:
	 * The length of the given array will be in range [3,10^4] and all elements are in the range [-1000, 1000].
	 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
	 * 
	 **/
	public static void main(String[] args) {
		System.out.println(maximumProduct(new int[]{1,2,3}));
		System.out.println(maximumProduct(new int[]{1,2,3,4}));
	}

	//Short solution using sorting O(nlogn), faster solution would be finding max 3 and min 2 in O(n) time
	public static int maximumProduct(int[] nums) {
		 Arrays.sort(nums);
		 return nums[nums.length-1] * Math.max(nums[nums.length-2]*nums[nums.length-3], nums[0]*nums[1]);
	}
}
