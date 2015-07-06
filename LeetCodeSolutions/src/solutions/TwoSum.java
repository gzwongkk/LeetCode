package solutions;

import java.util.HashMap;

public class TwoSum {
	/*
	 * Given an array of integers, find two numbers such that
	 * they add up to a specific target number
	 * The function twoSum should return indices of the two numbers
	 * such that they add up to the target, where index1 must be
	 * less than index2. Please note that your returned answers
	 * (both index1 and index2) are not zero-based.
	 * You may assume that each input would have exactly one solution.
	 * Input: numbers={2, 7, 11, 15}, target=9
	 * Output: index1=1, index2=2
	 */
	public static void main(String[] args){
		int[] input = {2, 7, 11, 15};
		int target = 9;
		int[] answer = twoSum(input, target);
		System.out.println(""+answer[0]+" "+answer[1]+" which are "+input[answer[0]-1]+" "+input[answer[1]-1]);
	}
	
	/*
	 * The solution should use hash data structure to get a runtime O(1)
	 * This allows each checking to be associated with only one element
	 * Thus results a O(n) algorithm in time and space. Brute force will give O(n^2).
	 * sorting the array is always one possible solution which gives 
	 * time = O(n log n) and space=O(n). This has better performance in practice.
	 */
	public static int[] twoSum(int[] nums, int target){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for( int i = 0; i < nums.length; ++i ){
			if( map.containsKey(target-nums[i]) )
				return new int[]{map.get(target-nums[i]),i+1};
			else{
				map.put(nums[i], i+1);
			}
		}
		return null;
	}
}
