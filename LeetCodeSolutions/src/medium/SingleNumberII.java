package medium;

public class SingleNumberII {

	/**
	 * Given an array of integers, every element appears three times except for one. 
	 * Find that single one.
	 * Note: Your algorithm should have a linear runtime complexity. 
	 * 		 Could you implement it without using extra memory?
	 **/
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{1,1,1,2,2,2,11,12,11,12,11,12,13}));
	}

	/*
	 * There are in total n/3+1 elements in the array. We can obtain the single number by counting
	 * the appearance of 1 and 0 in each binary digit. If the single number is 1 in that location,
	 * the number of 1s appeared should be 1 if we modulus three on it.
	 * 
	 * Some geniuses do a true table analysis on the outcome, and come out with the following fantastic
	 * equation. This reminds me the importance of the K-map technique.
	 */
	public static int singleNumber(int[] nums){
		int a = 0, b = 0;
		for( int num : nums ){
			a = ( a ^ num ) & (~b);
			b = ( b ^ num ) & (~a);
		}
		return a;
	}
}
