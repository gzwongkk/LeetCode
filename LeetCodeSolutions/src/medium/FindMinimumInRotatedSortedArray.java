package medium;

public class FindMinimumInRotatedSortedArray {

	/**
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	 * i.e. 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2. Find the minimum element.
	 * You may assume no duplicate exists in the array.
	 **/
	public static void main(String[] args) {
		System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
		System.out.println(findMin(new int[]{2,3,4,5,1}));
		System.out.println(findMinLow(new int[]{4,5,6,7,0,1,2}));
		System.out.println(findMinLow(new int[]{2,3,4,5,1}));
	}

	/*
	 * Exactly the same as in the mid-term paper in COMP3711. Binary search.
	 * There is a slight difference if we choose to return high or low.
	 */
	public static int findMin(int[] nums){
		int low = 0, high = nums.length-1;
		while( low < high ){
			int mid = ( low + high ) / 2;
			if( nums[mid] < nums[high] ) high = mid;
			else low = mid+1;
		}
		return nums[high];
	}
	
	public static int findMinLow(int[] nums){
		int low = 0, high = nums.length-1;
		while( low < high ){
			int mid = low + ( high - low ) / 2;
			if( nums[mid] < nums[high] ) high = mid;
			else low = mid+1;
		}
		return nums[low];
	}
}
