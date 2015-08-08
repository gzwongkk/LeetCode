package medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class FourSum {

	/**
	 * Given an array S of n integers, are there elements a, b, c, and d in S such that 
	 * a + b + c + d = target? Find all unique quadruples in the array which gives the sum of target.
	 * Note: Elements in a quadruple (a,b,c,d) must be in non-descending order.
	 * 		 The solution set must not contain duplicate quadruples.
	 * For example, given array S = {1, 0, -1, 0, -2, 2} and target = 0,
	 * A solution set is:
	 * 	(-1,  0, 0, 1)
	 *  (-2, -1, 1, 2)
	 *  (-2,  0, 0, 2)
	 **/
	public static void main(String[] args) {
		System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
		System.out.println(fourSum(new int[]{-3,-1,0,2,4,5}, 0));
		System.out.println(fourSum(new int[]{3,1,4,2,5,-4,2,4,-5}, -12));
		System.out.println(fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
	}

	/*
	 * There is a theoretically O(n^2 log n) solution, but actual runtime should not be better than this O(n^3) version because,
	 * that requires a huge memory for O(1) retrieval time, as combining two integers and make it a two sum problem.
	 * Notice that there is a failed attempt listed here, which looks really nice. Yet, this algorithm fails the case when the
	 * given boundary cases are balanced, strictly speaking, it fails to handle the case where 
	 * nums[outerLeft+1] + nums[outerRight-1] - sum == 0; Otherwise it is fine.
	 */
	public static List<List<Integer>> fourSum(int[] nums, int target){
		LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
		if( nums.length < 4 ) return ans;
		Arrays.sort(nums);
		for( int outerLeft = 0; outerLeft < nums.length-3; ++outerLeft ){
			if( outerLeft > 0 && nums[outerLeft-1] == nums[outerLeft] ) continue;
			
			for( int outerRight = nums.length-1; outerLeft < outerRight-2; --outerRight ){
				if( outerRight < nums.length-1 && nums[outerRight] == nums[outerRight+1] ) continue;
				
				int innerLeft  = outerLeft+1, innerRight = outerRight-1, sum = target - nums[outerLeft] - nums[outerRight];
				while( innerLeft < innerRight ){
					if( nums[innerLeft] + nums[innerRight] < sum ) ++innerLeft;
					else if( nums[innerLeft] + nums[innerRight] == sum ){
						ans.add(new ArrayList<Integer>(Arrays.asList(nums[outerLeft], nums[innerLeft], nums[innerRight], nums[outerRight])));
						do{ ++innerLeft; } while( innerLeft < innerRight && nums[innerLeft-1] == nums[innerLeft] );
						do{ --innerRight;} while( innerLeft < innerRight && nums[innerRight+1]== nums[innerRight]);
					} else --innerRight;
				}
			}
		}
		return ans;
	}
	
	public List<List<Integer>> fourSumFailed(int[] nums, int target) {
		LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
		if( nums.length < 4 ) return ans;
		Arrays.sort(nums);
		int outerLeft = 0, outerRight = nums.length-1;
		while( outerLeft < outerRight ){
			int innerLeft  = outerLeft+1, innerRight = outerRight-1, sum = target - nums[outerLeft] - nums[outerRight];
			while( innerLeft < innerRight ){
				if( nums[innerLeft] + nums[innerRight] < sum ) ++innerLeft;
				else if( nums[innerLeft] + nums[innerRight] == sum ){
					ArrayList<Integer> quadruple = new ArrayList<Integer>(4);
					quadruple.add(nums[outerLeft]);
					quadruple.add(nums[innerLeft]);
					quadruple.add(nums[innerRight]);
					quadruple.add(nums[outerRight]);
					ans.add(quadruple);
					do{ ++innerLeft; } while( innerLeft < innerRight && nums[innerLeft-1] == nums[innerLeft] );
					do{ --innerRight;} while( innerLeft < innerRight && nums[innerRight+1]== nums[innerRight]);
				} else --innerRight;
			}
			if( nums[outerLeft+1] + nums[outerRight-1] - sum > 0 )
				do{ --outerRight;} while( outerLeft < outerRight && nums[outerRight+1]== nums[outerRight]);
			else
				do{ ++outerLeft; } while( outerLeft < outerRight && nums[outerLeft-1] == nums[outerLeft] );
		}
		return ans;
    }
}
