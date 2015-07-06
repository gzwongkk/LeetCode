package solutions;

public class MedianOfTwoSortedArrays {
	/*
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
	 * Find the median of the two sorted arrays. The overall run time complexity
	 * should be O(log(m+n)).
	 */

	public static void main(String[] args) {
		int[] input1 = new int[]{3};
		int[] input2 = new int[]{1,2,4};
		System.out.println(findMedianSortedArrays(input1, input2));
	}

	/*
	 * Since it said it is in O(log(m+n)), it must use the technique of divide and conquer.
	 * In this case, binary search works well. Finding the median is easy part.
	 * But consider the property of median, if number of elements is even, one needs to
	 * compute the average of i and i+1 term. This requires extremely careful of case consideration.
	 */	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2){
		int m = nums1.length, n = nums2.length;
		if( m > n )
			return findMedianSortedArrays(nums2, nums1);
		int k = (m+n-1)/2, i = 0, j = Math.min(m, k);
		while( i < j ){
			int split = (i+j)/2;
			if( nums1[split] < nums2[k-split] )
				i = split+1;
			else
				j = split;
		}
		double ans;
		if( i > 0 )
			if( k-i >= 0 && nums1[i-1] <= nums2[k-i])
				ans = nums2[k-i];
			else
				ans = nums1[i-1];
		else 
			ans = nums2[k-i];
		if( ((m+n)&1) == 1 ){
			return ans;
		} else {
			double nextOfAns;
			if( i < m )
				if( k - i + 1 < n && nums1[i] >= nums2[k-i+1] )
					nextOfAns = nums2[k-i+1];
				else
					nextOfAns = nums1[i];
			else
				nextOfAns = nums2[k-i+1];
			return (ans+nextOfAns)/2;
		}
	}
}
