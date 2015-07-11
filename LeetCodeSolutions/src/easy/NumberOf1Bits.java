package easy;

public class NumberOf1Bits {

	/**
	 * Write a function that takes an unsigned integer and return the number
	 * of '1' bits it has (also known as the Hamming weight).
	 * For example, the 32-bit integer '11' has binary representation 
	 * 00000000000000000000000000001011, so the function should return 3.
	 **/

	public static void main(String[] args){
		System.out.println(hammingWeight(11));
	}

	/*
	 * n & n-1 cancel out an one. Simply count how many this operation can run
	 * before it reaches 0. Voila, c'est la solution. 
	 */
	public static int hammingWeight(int n){
		int ans = 0;
		while(n != 0){
			n &= n - 1;
			++ans;
		}
		return ans;
	}
}
