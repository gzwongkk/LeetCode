package easy;

public class MajorityElement {

	/**
	 * Given an array of size n, find the majority element. The majority element is the element
	 * that appears more than n/2 times.
	 * You may assume that they array is non-empty and the majority element always exist in the array.
	 */
	public static void main(String[] args) {
		int[] nums = new int[]{0,1,0,1,0,1,0,2,5,3,6,1,1,1,1,8,8,8,8,8,8,8,8,8,8,8,8,888,8,8,8,8,8,0};
		System.out.println(majorityElement(nums));
	}

	/*
	 * O(n) time O(1) space. The requirement of majority has given a large hint.
	 * If some elements appear more than n/2 times, the number of that element minus 
	 * the number of all other elements is always positive. This gives the following algorithm.
	 */
	public static int majorityElement(int[] nums){
		int majority = nums[0], count = 0;
		for( int i = 0 ;i < nums.length; ++i ){
			if( nums[i] == majority ) {
				++count;
			} else if( count == 0 ) {
				majority = nums[i];
				count = 1;
			} else {
				--count;
			}
		}
		return majority;
	}
}
