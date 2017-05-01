package easy;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
	/**
	 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
	 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
	 * 
	 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
	 * If it does not exist, output -1 for this number.
	 * 
	 * Note:
	 * All elements in nums1 and nums2 are unique.
	 * The length of both nums1 and nums2 would not exceed 1000.
	 **/
	public static void main(String[] args) {
		for ( int i : nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}) ) {
			System.out.print(i+" ");
		}
		
		System.out.println();

		for ( int i : nextGreaterElement(new int[]{1,3,5,2,4}, new int[]{6,5,4,3,2,1,7}) ) {
			System.out.print(i+" ");
		}
	}

	/*
	 * The uniqueness remark suggests you should use a map.
	 * The next greater element is actually a turning point in a decreasing trend. Using a stack can track this.
	 */
	public static int[] nextGreaterElement(int[] findNums, int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<>();
		for ( int i = 0 ; i < nums.length; ++i ) {
			while ( !stack.isEmpty() && nums[i] > stack.peek() ) {
				map.put(stack.pop(), nums[i]);
			}
			stack.push(nums[i]);
		}
		
		int[] ans = new int[findNums.length];
		for ( int i = 0; i < ans.length; ++i ) {
			Integer a = map.get(findNums[i]);
			ans[i] = a == null? -1: a;
		}
		
		return ans;
	}
}
