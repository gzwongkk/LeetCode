package easy;

public class PlusOne {

	/**
	 * Given a non-negative number represented as an array of digits, plus one to the number.
	 * The digits are stored such that the most significant digit is at the head of the list.
	 **/
	public static void main(String[] args) {
		int[] input = new int[]{9,9,9,9,9,9,9,9,9};
		for(int i : plusOne(input))
			System.out.print(i);
	}

	/*
	 * Use carryIn to do addition. Java initialization trick helps a lot in this problem.
	 */
	public static int[] plusOne(int[] digits){
		if( digits.length == 0 ) return new int[]{1};
		int carry = 1;
		for( int i = digits.length-1; i >= 0; --i ){
			if( digits[i] == 9 && carry == 1){
				carry = 1;
				digits[i] = 0;
			} else {
				digits[i] += carry;
				carry = 0;
				break;
			}
		}
		if( carry == 1 ){
			digits = new int[digits.length+1];
			digits[0] = 1;
		}
		return digits;
	}
}
