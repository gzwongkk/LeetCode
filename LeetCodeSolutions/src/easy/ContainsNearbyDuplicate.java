package easy;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsNearbyDuplicate {

	/**
	 * Given an array of integers and an integer k, find out whether there are two
	 * distinct indices i and j in the array such that nums[i] = nums[j] and the 
	 * difference between i and j is at most k.
	 **/
	public static void main(String[] args) {
		int[] nums = new int[]{};
		int k = 0;
		System.out.println(containsNearbyDuplicate(nums, k));
	}

	/*
	 * Similar to ContainsDuplicate, but this time we only need a range of elements
	 * at a time in the hash table.
	 * Note that HashSet do nothing return false when object exists.
	 */
	public static boolean containsNearbyDuplicate(int[] nums, int k){
		HashSet<Integer> table = new HashSet<Integer>();
		for( int i = 0; i < nums.length; ++i ){
			if( i > k )	table.remove(nums[i-k-1]);
			if( !table.add(nums[i]) )	return true;
		}
		return false;
	}

	/*
	 * Or use a HashMap to keep track of the sliding window.
	 * Note that HashMap replace old value with same key.
	 */
	public static boolean containsNearbyDuplicateMap(int[] nums, int k){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for( int i = 0; i < nums.length; ++i ){
			if( map.containsKey(nums[i]) && map.get(nums[i])+k >= i )
				return true;
			else
				map.put(nums[i], i);
		}
		return false;
	}
}
