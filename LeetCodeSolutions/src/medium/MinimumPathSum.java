package medium;

public class MinimumPathSum {
	/**
	 * Given a m x n grid filled with non=negative numbers, find a path from top left to
	 * bottom right which minimizes the sum of all numbers along its path.
	 * Note: You can only move either down or right at any point in time.
	 **/
	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][]{{0,1},{1,0}}));
		System.out.println(minPathSum(new int[][]{{1,2,3},{3,2,1}}));
	}

	/*
	 * Classic DP problem, remember that DP problem requiring only value not path uses only
	 * a 1D array (i.e. O(n) space).
	 */
	public static int minPathSum(int[][] grid){
		int[] dp = new int[grid[0].length];
		dp[0] = grid[0][0];
		for( int j = 1; j < grid[0].length; ++j )
			dp[j] = dp[j-1] + grid[0][j];
		for( int i = 1; i < grid.length; ++i ){
			dp[0] += grid[i][0];
			for( int j = 1; j < grid[0].length; ++j )
				dp[j] = Math.min(dp[j-1]+grid[i][j], dp[j]+grid[i][j]);
		}
		return dp[grid[0].length-1];
	}
}
