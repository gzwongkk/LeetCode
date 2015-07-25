package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	/**
	 * Given an array S of n integers, are there elements a, b, c in S such that a+b+c = 0?
	 * Find all unique triplets in the array which gives the sum of zero.
	 * Note:
	 * 	Elements in a triplet (a,b,c) must be in non-descending order.(ie, a <= b <= c)
	 * 	The solution set must not contain duplicate triplets.
	 * For example, given array S = {-1, 0, 1, 2, -1, -4}, a solution set is:
	 * {(-1, 0, 1), (-1,-1, 2)}
	 **/
	public static void main(String[] args) {
		int[] nums = new int[]{-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}

	/*
	 * Long introduced back in the algorithm course, finally got a chance to implement.
	 * The taught method is good in general, but to cater the specified requirements in
	 * this problem, the following window solution should be one of the finest. This does
	 * not require deleting duplicates as well as any extra spaces. The key is also the
	 * same, which is to reduce this into a two sum problem and sort the numbers array.
	 */
	public static List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if( nums.length <= 2 ) return ans;
		Arrays.sort(nums);
		for( int i = 0; i < nums.length-2; ++i){
			if( i > 0 && nums[i-1] == nums[i] ) continue;
			int left = i + 1, right = nums.length-1, twoSum = -nums[i];
			while( left < right ){
				if( nums[left]+nums[right] < twoSum ) ++left;
				else if( nums[left]+nums[right] == twoSum ){
					ArrayList<Integer> triplet = new ArrayList<Integer>();
					triplet.add(nums[i]);
					triplet.add(nums[left]);
					triplet.add(nums[right]);
					ans.add(triplet);
					do{ ++left; } while( left < right && nums[left-1] == nums[left] );
					do{ --right;} while( left < right && nums[right+1]== nums[right]);
				}
				else --right;
			}
		}
		return ans;
	}
}
