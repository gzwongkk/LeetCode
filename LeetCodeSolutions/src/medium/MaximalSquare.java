package medium;

public class MaximalSquare {

	/**
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing
	 * all 1's and return its area.
	 * For example, given the following matrix:
	 * 
			1 0  1 0  0
			1 0 '1 1' 1
			1 1 '1 1' 1
			1 0  0 1  0
			
	 * return 4
	 **/
	public static void main(String[] args) {
		char[][] matrix = new char[][]{
				{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}};
		for( int j = 0; j < matrix.length; ++j ){
			for( int i = 0; i < matrix[0].length; ++i ){
				System.out.print(matrix[j][i]+" ");
			}
			System.out.println();
		}
		System.out.println(maximalSquare(matrix));
		System.out.println(maximalSquare(new char[][]{}));
		System.out.println(maximalSquare(new char[][]{{'1'}}));
	}

	/*
	 * This question is designed for DP. In my thoughts, I first go for brute force which is exponential
	 * in runtime, then thought of some tricks to reduce it. However, I failed to analyze an explicit
	 * runtime as many cases can happen, so I start thinking about a recursive way which is how to build
	 * up a square. This turns out to be an O(n^2) time O(width) space DP solution.
	 * 
	 * Remember that X and Y are reversed in arrays. 
	 */
	public static int maximalSquare(char[][] matrix){
		if( matrix.length == 0 || matrix[0].length == 0 ) return 0;
		int max = 0, topLeft = 0, width = matrix[0].length, height = matrix.length;
		int[] dp = new int[width];
		for( int j = 0; j < height; ++j ){
			topLeft = dp[0];
			dp[0] = matrix[j][0] == '1'? 1: 0;
			max = Math.max(max, dp[0]);
			for( int i = 1; i < width; ++i ){
				int temp = dp[i];
				dp[i] = matrix[j][i] == '0'? 0: Math.min(dp[i], Math.min(dp[i-1], topLeft))+1;
				topLeft = temp;
				max = Math.max(max, dp[i]);
			}
		}
		return max*max;
	}
}
