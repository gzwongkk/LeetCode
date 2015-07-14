package easy;

public class RemoveDuplicatesFromSortedArray {

	/**
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length.
	 * Do not allocate extra space for another array, you must do this in place with
	 * constant memory. For example, Given input array nums = [1,1,2],
	 * Your function should return length = 2, with the first two elements of nums being
	 * 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
	 **/
	public static void main(String[] args) {
		int[] input = new int[]{1,1,2};
		System.out.println(removeDuplicates(input));
	}

	/*
	 * Modification of the Hoare's algorithm(partition in quick sort).
	 */
	public static int removeDuplicates(int[] nums){
		if( nums == null || nums.length == 0 ) return 0;
		int newSize = 0;
		for( int i = 1; i < nums.length; ++i )
			if( nums[newSize] != nums[i] )
				nums[++newSize] = nums[i];
		return newSize+1;
	}
}
