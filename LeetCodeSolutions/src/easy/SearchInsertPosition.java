package easy;

public class SearchInsertPosition {
	/**
	 * Given a sorted array and a target value, return the index if the target is found. If not, 
	 * return the index where it would be if it were inserted in order.
	 * 
	 * You may assume no duplicates in the array.
	 * Here are few examples.
	 * 
	 * [1,3,5,6], 5 -> 2
	 * [1,3,5,6], 2 -> 1
	 * [1,3,5,6], 7 -> 4
	 * [1,3,5,6], 0 -> 0
	 **/
	public static void main(String[] args) {
		System.out.println(searchInsert(new int[]{1,3,5,6},5));
		System.out.println(searchInsert(new int[]{1,3,5,6},2));
		System.out.println(searchInsert(new int[]{1,3,5,6},7));
		System.out.println(searchInsert(new int[]{1,3,5,6},0));
	}

	public static int searchInsert(int[] nums, int target) {
		int i = 0, j = nums.length-1;
		
		while ( i <= j ) {
			int k = (j-i)/2+i;
			if ( nums[k] == target ) return k;
			else if ( nums[k] < target ) i = k+1;
			else j = k-1;
		}
		
		return i;
	}
}
