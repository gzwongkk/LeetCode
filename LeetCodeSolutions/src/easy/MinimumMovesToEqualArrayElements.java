package easy;

public class MinimumMovesToEqualArrayElements {
	/**
	 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array 
	 * elements equal, where a move is incrementing n - 1 elements by 1.
	 **/
	public static void main(String[] args) {
		System.out.println(minMoves(new int[]{1, 2, 3}));
	}

	/*
	 * Suppose we need all elements to be x, then the required moves would be move = x-min.
	 * x*n = sum + move * (n-1)
	 * x*n = sum + move*n - move
	 * ( move + min ) * n = sum + move * n - move
	 * move = sum - min * n
	 */
	public static int minMoves(int[] nums) {
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for ( int i = 0; i < nums.length; ++i ) {
			sum += nums[i];
			min = Math.min(nums[i], min);
		}
				
		return sum - min * nums.length;
	}
}
