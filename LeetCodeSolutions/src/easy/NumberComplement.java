package easy;

public class NumberComplement {
	/**
	 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
	 * Note:
	 * 1.	The given integer is guaranteed to fit within the range of a 32-bit signed integer.
	 * 2.	You could assume no leading zero bit in the integer's binary representation.
	 * Example:
	 * Input:5 Output:2
	 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
	 **/
	public static void main(String[] args) {
		System.out.println(numberComplement(5));
		System.out.println(numberComplement(99999));
		System.out.println(numberComplement2(5));
		System.out.println(numberComplement2(99999));
	}

	/*
	 * Identify and delete original leading zeros from exclusive or / negation.
	 */
	public static int numberComplement(int num) {
		int complement = num^Integer.MAX_VALUE, pos = 0;
		while ( (num>>pos) > 0 ) ++pos;
		return (complement << (32-pos)) >> (32-pos);
	}
	
	public static int numberComplement2(int num) {
		int ans = ~num, pos = 0;
		while ( (num>>pos) > 0 ) ++pos;
		return (ans << (32-pos)) >> (32-pos);
	}
}
