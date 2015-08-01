package medium;

public class JumpGame {

	/**
	 * Given an array of non-negative integers, you are initially positioned at the first
	 * index of the array. Each element in the array represents your maximum jump length
	 * at that position. Determine if you are able to reach the last index. For example,
	 * A = [2,3,1,1,4], return true.
	 * A = [3,2,1,0,4], return false.
	 **/
	public static void main(String[] args) {
		int[] nums = new int[]{2,3,1,1,4};
		System.out.println(canJump(nums));
	}

	/*
	 * DP solution. Since we only need to return true and false at the end, we don't have to
	 * backtrack and thus, a better solution requires constant space only. It simply improves DP.
	 */
	public static boolean canJump(int[] nums){
		int canReach = 0;
		for( int i = 0; i <= canReach; ++i){
			if( i + nums[i] > canReach ) canReach = i + nums[i];
			if( canReach >= nums.length-1 ) return true;
		}
		return false;
	}
	
	public static boolean canJumpDP(int[] nums){
		if( nums.length == 0 ) return false;
		boolean[] canReach = new boolean[nums.length];
		canReach[0] = true;
		for( int i = 0; i < nums.length; ++i ){
			if( canReach[i] ){
				if( i + nums[i] >= nums.length ) return true;
				for( int j = 1; j <= nums[i] && i+j < nums.length; ++j ){
					canReach[i+j] = true;
				}
			}
		}
		return canReach[nums.length-1];
	}
}
