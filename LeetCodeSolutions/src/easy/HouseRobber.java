package easy;

public class HouseRobber {

	/**
	 * You are a professional robber planning to rob houses along a street.
	 * Each house has a certain amount of money stashed, the only constraint
	 * stopping you from robbing each of them is that adjacent houses have 
	 * security system connected and it will automatically contact the police
	 * if two adjacent houses were broken into on the same night.
	 * Given a list of non-negative integers representing the amount of money
	 * of each house, determine the maximum amount of money you can rob tonight
	 * without alerting the police.
	 */
	public static void main(String[] args) {
		int[] input = new int[]{4,9,7,1};
		System.out.println(rob(input));
	}

	/*
	 * Greedy doesn't work. DP can do it in O(n) time. Clever trick can make it O(1) space.
	 */
	public static int rob(int[] nums){
		if( nums == null ) return 0;
		int mi = 0, mj = 0;
		for( int i : nums ){
			int temp = mi;
			mi = Math.max(mi, mj);
			mj = i + temp;
		}
		return Math.max(mi, mj);
	}
	
	public static int robArray(int[] nums){
		if( nums == null || nums.length == 0 ) return 0;
		else if( nums.length == 1 ) return nums[0];
		int[] m = new int[nums.length];
		m[0] = nums[0];
		m[1] = Math.max(nums[0], nums[1]);
		for( int i = 2; i < nums.length; ++i ){
			if( m[i-2]+nums[i] > m[i-1] )
				m[i] = m[i-2]+nums[i];
			else
				m[i] = m[i-1];
		}
		return m[m.length-1];
	}
}
