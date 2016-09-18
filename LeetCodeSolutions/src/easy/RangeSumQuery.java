package easy;

public class RangeSumQuery {
	/**
	 * Given an integer array nums, find the sum of the elements between indices i and j ( i <= j) , inclusive.
	 * 
	 * nums = [-2, 0, 3, -5, 2, -1]
	 * sumRange(0, 2) -> 1
	 * sumRange(2, 5) -> -1
	 * sumRange(0, 5) -> -3
	 * 
	 * You may assume that the array does not change.
	 * There are many calls to sumRange function.
	 **/
	public static void main(String[] args) {
		RangeSumQuery test = new RangeSumQuery(new int[]{-2, 0, 3, -5, 2, -1});
		System.out.println(test.sumRange(0, 2));
		System.out.println(test.sumRange(2, 5));
		System.out.println(test.sumRange(0, 5));
	}

	/*
	 * (i, j) = (0, j) - (0, i)
	 */
	public int[] sum;
	
	public RangeSumQuery(int[] nums) {
		sum = new int[nums.length+1];
		int s = 0;
		for( int i = 0; i < nums.length; ++i) {
			s += nums[i];
			sum[i+1] = s;
		}
	}
	
	public int sumRange(int i, int j) {
		return sum[j+1]-sum[i];
	}
}
