package easy;

public class MoveZeroes {
	/**
	 * Given an array nums, write a function to move all 0's to the end of it while maintaining
	 * the relative order of the non-zero elements.
	 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
	 **/
	public static void main(String[] args) {
		int[] test = new int[]{0,1,0,3,12};
		moveZeroes(test);
		for( int i : test )
			System.out.print(i+" ");
	}

	/*
	 * My solution is better than the general solution for removing same value from an array
	 * because at any case it only goes through once.
	 */
	public static void moveZeroes(int[] nums){
		for( int i = 0, j = 1; i < nums.length; ++i, ++j )
			if( nums[i] == 0 ){
				while( j < nums.length && nums[j] == 0 ) ++j;
				if( j >= nums.length ) break;
				else{
					nums[i] = nums[j];
					nums[j] = 0;
				}
			}
	}
	
	public static void removingSameValue(int[] nums){
		int i = 0;
		for( int num : nums ) 
			if( num != 0 ) nums[i++] = num;
		while( i < nums.length ) nums[i++] = 0;
	}
}
