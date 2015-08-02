package medium;

public class SingleNumber {

	/**
	 * Given an array of integers, every element appears twice except for one. Find that
	 * single one. Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 **/
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{1,2,3,6,5,8,9,8,6,3,5,2,1}));
	}

	/*
	 * N ^ N = 0. Given this property of XOR, the single element will be the only remaining 
	 * number as 0 ^ ... ^ 0 ^ S = S.
	 */
	public static int singleNumber(int[] nums){
		int single = 0;
		for( int n : nums )	single ^= n;
		return single;
	}
}
