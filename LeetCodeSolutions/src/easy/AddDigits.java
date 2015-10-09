package easy;

public class AddDigits {
	/**
	 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
	 * For example: Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2.
	 * Since 2 has only one digit, return it.
	 * Follow up: Could you do it without any loop/recursion in O(1) time?
	 **/
	public static void main(String[] args) {
		System.out.println(addDigits(1159));
	}

	/*
	 * Whenever O(1) is stated, investigate in all operators because these are the only solutions.
	 */
	public static int addDigits(int num){
		return 1 + ( num - 1 ) % 9;
	}
}
