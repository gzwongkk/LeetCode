package easy;

public class MaxConsecutiveOnes {
	/**
	 * Given a binary array, find the maximum number of consecutive 1s in this array.
	 **/
	public static void main(String[] args) {
		System.out.println(maxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
	}

	/*
	 * No way to do less than one pass.
	 */
	public static int maxConsecutiveOnes(int[] nums) {
		int max = 0, temp = 0;
		for ( int n : nums ) {
			if ( n == 0 ) {
				max = Math.max(max, temp);
				temp = 0;
			} else {
				++temp;
			}
		}
		return Math.max(max, temp);
	}
}
