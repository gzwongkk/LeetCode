package easy;
public class ReverseBits {

	/**
	 * Reverse bits of a given 32 bits unsigned integer.
	 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
	 * return 964176192 (represented in binary as 00111001011110000010100101000000).
	 * Follow up: if this function is called many times, how would you optimize it?
	 */
	
	public static void main(String[] args) {
		int input = 1;
		System.out.println(reverseBits(input));
	}

	/*
	 * Traverse all bits to get result. 
	 * To optimize runtime, truncate it into smaller parts to deal with.
	 */
	public static int reverseBits(int n){
		int ans = 0;
		for(int i = 0; i < 31; ++i){
			ans += n & 1;
			ans <<= 1;
			n >>>= 1;
		}
		return ans + (n & 1);
	}
}
