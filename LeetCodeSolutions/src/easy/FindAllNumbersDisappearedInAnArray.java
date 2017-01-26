package easy;
import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
	/**
	 * Given an array of integers where 1 <= a[i] <= n (n = size of array), some elements appear twice and others appear once.
	 * Find all the elements of [1, n] inclusive that do not appear in this array.
	 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
	 * Example:
	 * Input:  [4,3,2,7,8,2,3,1]
	 * Output: [5,6]
	 **/
	public static void main(String[] args) {
		System.out.println(findAllNumbersDisappearedInAnArray(new int[]{4,3,2,7,8,2,3,1}));
		System.out.println(findAllNumbersDisappearedInAnArrayOnePass(new int[]{4,3,2,7,8,2,3,1}));
	}

	/*
	 * Swapping the elements to the position aligning with the index. This takes at most two passes. Then check for unaligned elements.
	 * 
	 * One pass solution is to use mask by negating.
	 */
	public static List<Integer> findAllNumbersDisappearedInAnArray(int[] nums) {
		ArrayList<Integer> list = new ArrayList<>();
		for ( int i = 0, n = 0; i < nums.length; ++i ) {
			while ( nums[nums[i]-1] != nums[i] ) {
				n = nums[nums[i]-1];
				nums[nums[i]-1] = nums[i];
				nums[i] = n;
			}
		}
		for ( int i = 0; i < nums.length; ++i ) {
			if ( nums[i] != i+1 ) list.add(i+1);
		}
		return list;
	}
	
	public static List<Integer> findAllNumbersDisappearedInAnArrayOnePass(int[] nums) {
		ArrayList<Integer> list = new ArrayList<>();
		for ( int i = 0; i < nums.length; ++i ) {
			int n = Math.abs(nums[i]) - 1;
            if ( nums[n] > 0 ) nums[n] = -nums[n];
		}
		for ( int i = 0; i < nums.length; ++i ) {
			if ( nums[i] > 0 ) list.add(i+1);
		}
		return list;
	}
}
