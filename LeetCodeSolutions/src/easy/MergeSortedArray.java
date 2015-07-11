package easy;

public class MergeSortedArray {

	/**
	 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	 * Note:
	 * 	You may assume that nums1 has enough space ( size that is greater or equal to m+n ) to hold
	 * additional elements from nums2. The number of elements initialized in nums1 and num2 are m and n respectively.
	 */
	public static void main( String[] args ) {
		int m = 10, n = 10;
		int[] nums1 = new int[m+n], nums2 = new int[n];
		for( int i = 0; i < m; ++i ){
			nums1[i] = i*2+1;
			nums2[i] = i*2;
		}
		merge( nums1, m, nums2, n );
		for( int i : nums1 )
			System.out.print(i+" ");
	}
	
	/*
	 * Neat and tidy. This is quite similar to the hi/lo thing in MIPS.
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n){
		while( n > 0 )
			nums1[m+n-1] = m > 0 && nums1[m-1] > nums2[n-1] ? nums1[--m] : nums2[--n];
	}
}
