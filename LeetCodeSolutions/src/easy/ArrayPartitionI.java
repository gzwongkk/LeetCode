package easy;

import java.util.Arrays;

public class ArrayPartitionI {
	/**
	 * Given an array of 2n integers, your task is to group these integers into n pairs
	 * of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi)
	 * for all i from 1 to n as large as possible.
	 **/
	public static void main(String[] args) {
		System.out.println(arrayPairSum(new int[]{1,4,3,2}));
	}

	/*
	 * Simple recursive proof: since the minimum number must be added to the sum, pairing it up with the second
	 * minimal will only make the sum larger or equal to any other cases. 
	 */
	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for( int i = 0; i < nums.length; i+=2 ) {
			sum += nums[i];
		}
		return sum;
	}
}
