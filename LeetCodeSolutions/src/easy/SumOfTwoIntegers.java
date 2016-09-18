package easy;

public class SumOfTwoIntegers {
	/**
	 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
	 * Given a = 1 and b = 2, return 3.
	 **/
	public static void main(String[] args) {
		System.out.println(getSum(1, 2));
		System.out.println(getSum(9, 12312));
		System.out.println(getSum(11345, 22345));
	}

	/*
	 * Just decompose the addition process into bitwise operations.
	 */
	public static int getSum(int a, int b) {
		int c;
		
		do {
			c = a & b;
			a = ( a | b ) ^ c;
			b = c << 1;
		} while ( c != 0 );
		
		return a;
	}
}
