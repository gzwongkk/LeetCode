package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KdiffPairs {
	/**
	 * Given an array of integers and an integer k, you need to find the number of unique k-diff 
	 * pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j 
	 * are both numbers in the array and their absolute difference is k.
	 * 
	 * Example 1:
	 * Input: [3, 1, 4, 1, 5], k = 2
	 * Output: 2
	 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
	 * Although we have two 1s in the input, we should only return the number of unique pairs.
	 * 
	 * Example 2:
	 * Input:[1, 2, 3, 4, 5], k = 1
	 * Output: 4
	 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
	 * 
	 * Example 3:
	 * Input: [1, 3, 1, 5, 4], k = 0
	 * Output: 1
	 * Explanation: There is one 0-diff pair in the array, (1, 1).
	 * 
	 * Note:
	 * The pairs (i, j) and (j, i) count as the same pair.
	 * The length of the array won't exceed 10,000.
	 * All the integers in the given input belong to the range: [-1e7, 1e7].
	 **/
	public static void main(String[] args) {
		System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
		System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 1));
		System.out.println(findPairs(new int[]{1, 3, 1, 5, 4}, 0));
		System.out.println(findPairs(new int[]{10000000, 10000000}, 0));
		System.out.println(findPairs(new int[]{-10000000, -10000000}, 0));
		System.out.println(findPairs(new int[]{-10000000+1, -10000000, 10000000-1, 10000000}, 1));
	}

	/*
	 * Both O(n log n) Time
	 * 1. Using Sort O(1) space ~16ms 
	 * 2. Using HashMap O(n) space ~34ms
	 */
	public static int findPairs(int[] nums, int k) {
		return findPairsSort(nums, k);
	}
	
	public static int findPairsSort(int[] nums, int k) {
        if ( nums == null || nums.length == 0 || k < 0 ) return 0;
        Arrays.sort(nums);
        
        int pairs = 0;
		for ( int i = 0, j = 1; i < nums.length; ++i ) {
			for ( j = Math.max(j, i+1); j < nums.length && nums[j]-nums[i] < k; ++j);
			if ( j < nums.length && nums[j]-nums[i] == k ) ++pairs;
			while ( i + 1 < nums.length && nums[i] == nums[i+1] ) ++i;
		}
        
		return pairs;
	}
	
	public static int findPairsMap(int[] nums, int k) {
        if ( nums == null || nums.length == 0 || k < 0 ) return 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for ( int n : nums ) map.put(n, map.getOrDefault(n, 0)+1);
		
		int pairs = 0;
		for ( Map.Entry<Integer, Integer> pair : map.entrySet() ) {
			if ( k == 0 ) {
				if ( pair.getValue() >= 2 ) ++pairs;
			} else {
				if ( map.containsKey(pair.getKey()+k) ) ++pairs;
			}
		}
		return pairs;
	}
}
