package medium;

public class SortColors {
	/**
	 * Given an array with n objects colored red, white or blue, sort them so that
	 * objects of the same color are adjacent, with the colors in the order red, white
	 * and blue. Here, we will use the integers 0, 1, and 2 to represent the color red,
	 * white, and blue respectively.
	 * Note: You are not suppose to use the library's sort function for this problem.
	 **/
	public static void main(String[] args) {
		int[] nums = new int[]{0,0,0,2,1,2,1,0,1,2,1,2,0,1,2};
		sortColors(nums);
		for( int n : nums ) System.out.print(n + " ");
	}

	/*
	 * Similar to quick sort partition process, keep three pointers for the three groups,
	 * having the bottom group grows from bottom and top group grows from the end, the middle
	 * group should be just right after the bottom group.
	 */
	public static void sortColors(int[] nums){
		int i = 0, j = 0, k = nums.length;
		while( j < k ){
			if( nums[j] == 0 ){
				nums[j++] = nums[i];
				nums[i++] = 0;
			} else if( nums[j] == 2 ){
				nums[j] = nums[--k];
				nums[k] = 2;
			} else {
				++j;
			}
		}
	}
}
