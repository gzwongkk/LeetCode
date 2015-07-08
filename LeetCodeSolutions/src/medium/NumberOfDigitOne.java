package medium;

public class NumberOfDigitOne {

	/**
	 * Given an integer n, count the total number of digit 1
	 * appearing in all non-negative integers less than or equal to n.
	 * For example: Given n = 13, Return 6. 
	 * Because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
	 **/
	public static void main(String[] args) {
		int input = 999999999;
		System.out.println(countDigitOne(input));
	}
	
	/*
	 * By observation, basically it follows a digit multiplier.
	 * 0-9			:1		(1)
	 * 10-99		:19		(20)
	 * 100-999		:280	(300)
	 * 1000-9999	:3700	(4000)
	 * 10000-99999	:46000	(50000)
	 * 
	 * Consider two cases:
	 * 1) if the digit is 1, this means it will appear additionally for 
	 * 		the value of those previously checked+1 time.
	 * 2) else if digit >= 2, multiply it by the digit position.
	 * 		The rest will be handled in next iteration.
	 */
	public static int countDigitOne(int n){
		int ones = 0;
	    for (long m = 1; m <= n; m *= 10)
	        ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
	    return ones;
	}
}
