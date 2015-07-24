package medium;

public class FindPeakElement {

	/**
	 * A peak element is an element that is greater than its neighbors.
	 * Given an input array where num[i] != num[i+1], find a peak element and returns its index.
	 * The array may contain multiple peaks, in that case return the index to any one of the peaks
	 * is fine. You may imagine that num[-1] = num[n] = -inf.
	 * For example, in array[1,2,3,1], 3 is a peak element and your function should return the index
	 * number 2.
	 * Your solution should be in logarithmic complexity.
	 **/
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,1};
		System.out.println(findPeakElement(nums));
	}

	/*
	 * Appeared in one of the past paper, this is a typical binary search problem.
	 * Since the boundary is set to be -inf, the recursive case can be transformed
	 * into whenever an element is smaller, it indeed function as the boundary.
	 */
	public static int findPeakElement(int[] nums){
		int i = 0, j = nums.length-1, mid;
		while( i < j ){
			mid = ( i + j ) / 2;
			if( nums[mid] < nums[mid+1] ) i = mid+1;
			else j = mid;
		}
		return i;
	}
}
