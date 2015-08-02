package medium;

public class HouseRobberII {

	/**
	 * After robbing those houses on that street, the thief has found himself a new place for his
	 * thievery so that he will not get too much attention. This time, all houses at this place
	 * are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile,
	 * the security system for these houses remain the same as for those in the previous street.
	 * 
	 * Given a list of non-negative integers representing the amount of money of each house, determine
	 * the maximum amount of money you can rob tonight without alerting the police.
	 **/
	public static void main(String[] args) {
		System.out.println(rob(new int[]{1,1}));
	}

	/*
	 * Max = Max given first house is not robbed || Max given first house is robbed.
	 */
	public static int rob(int[] nums){
		if( nums.length == 0 ) return 0;
		else if ( nums.length == 1 ) return nums[0];
		
		int mi = 0, mj = 0;
		for( int i = 0; i < nums.length-1; ++i ){
			int temp = mi;
			mi = Math.max(mi, mj);
			mj = nums[i] + temp;
		}
		
		int ni = 0, nj = 0;
		for( int i = 1; i < nums.length; ++i ){
			int temp = ni;
			ni = Math.max(ni, nj);
			nj = nums[i] + temp;
		}
		
		return Math.max(Math.max(mi, mj), Math.max(ni, nj));
	}
}
