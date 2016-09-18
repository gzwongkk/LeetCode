package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IntersectionOfTwoArrays2 {
	/**
	 * Given two arrays, write a function to compute their intersection.
	 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
	 * 
	 * Each element in the result should appear as many times as it shows in both arrays.
	 * The result can be in any order.
	 **/
	public static void main(String[] args) {
		for ( int i : intersection(new int[]{1,2,2,1}, new int[]{2,2}) )
			System.out.println(i);
	}

	/*
	 * Using sorting similar to merge sort to use only constant space.
	 */
	public static int[] intersection(int[] nums1, int[] nums2){
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0, j = 0;
		while ( i < nums1.length && j < nums2.length ) {
			if ( nums1[i] == nums2[j] ) {
				list.add(nums1[i]);
				++i; ++j;
			} else {
				if ( nums1[i] < nums2[j] ) ++i;
				else ++j;
			}
		}
		
		int[] ans = new int[list.size()];
		Iterator<Integer> it = list.iterator();
		for ( int k = 0; it.hasNext(); ++k )
			ans[k] = it.next();
		return ans;
	}
}
