package easy;

import java.util.HashSet;

public class IntersectionOfTwoArrays {
	/**
	 * Given two arrays, write a function to compute their intersection.
	 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
	 * 
	 * Each element in the result must be unique.
	 * The result can be in any order.
	 **/
	public static void main(String[] args) {
		for ( int i : intersection(new int[]{1,2,2,1}, new int[]{2,2}) )
			System.out.println(i);
	}

	/*
	 * Classic tradeoff of memory and time. Using a hashset to compare or sorting similar to merge sort also do.
	 */
	public static int[] intersection(int[] nums1, int[] nums2){
		HashSet<Integer> set = new HashSet<>(), ans = new HashSet<>();
		for ( int n : nums1 ) set.add(n);
		for ( int n : nums2 ) 
			if ( set.contains(n) ) ans.add(n);
		int[] inter = new int[ans.size()];
		Integer[] ansSet = new Integer[ans.size()];
		ans.toArray(ansSet);
		for( int i = 0; i < inter.length; ++i )
			inter[i] = ansSet[i];
		return inter;
	}
}
