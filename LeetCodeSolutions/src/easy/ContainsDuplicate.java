package easy;

import java.util.HashSet;

public class ContainsDuplicate {

	/**
	 * Given an array of integers, find if the array contains any duplicates.
	 * Your function should return true if any value appears at least twice
	 * in the array, and it should return false if every element is distinct.
	 **/
	public static void main(String[] args) {
		int[] input = new int[]{0,1,2,3,5,7,9,4,5};
		System.out.println(containsDuplicate(input));
	}

	/*
	 * Two trivial ways to solve it: sort it or use a hash table.
	 * Sorting requires O(n log n) time but O(1) space, depending on the sorting method.
	 * Hash table has average runtime O(n) but O(n) space. 
	 */
	public static boolean containsDuplicate(int[] nums){
		HashSet<Integer> table = new HashSet<Integer>();
		for(int n : nums){
			if( table.contains(n) ) return true;
			else table.add(n);
		}
		return false;
	}

	public static boolean containsDuplicateCompact(int[] nums){
		HashSet<Integer> table = new HashSet<Integer>();
		for( int i = 0; i < nums.length && !table.contains(nums[i]); table.add(nums[i++]) );
		return false;
	}
}
