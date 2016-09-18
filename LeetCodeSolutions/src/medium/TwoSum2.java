package medium;

public class TwoSum2 {
	/**
	 * Given an array of integers that is already sorted in ascending order, find two numbers such that
	 * they add up to a specific target number.
	 * The function twoSum should return indices of the two numbers
	 * such that they add up to the target, where index1 must be
	 * less than index2. Please note that your returned answers
	 * (both index1 and index2) are not zero-based.
	 * You may assume that each input would have exactly one solution.
	 * Input: numbers={2, 7, 11, 15}, target=9
	 * Output: index1=1, index2=2
	 **/
	public static void main(String[] args){
		int[] input = {2, 7, 11, 15};
		int target = 9;
		int[] answer = twoSum(input, target);
		System.out.println(""+answer[0]+" "+answer[1]+" which are "+input[answer[0]-1]+" "+input[answer[1]-1]);
	}
	
	/*
	 * Two pointers solution, O(n) time O(1) space.
	 */
	public static int[] twoSum(int[] nums, int target){
		int i = 0, j = nums.length-1;
		while ( i < j ) {
			if ( nums[i] + nums[j] > target )		--j;
			else if ( nums[i] + nums[j] == target )	break;
			else									++i;
		}
		if ( i >= j ) return null;
		else return new int[]{i+1,j+1};
	}
}
