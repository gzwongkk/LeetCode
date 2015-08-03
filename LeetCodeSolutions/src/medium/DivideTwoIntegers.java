package medium;

public class DivideTwoIntegers {

	/**
	 * Divide two integers without using multiplication, division and mode operator.
	 * If it is overflow, return MAX_INT.
	 **/
	public static void main(String[] args) {
		for( int i = 0; i < 10000; ++i )
			if( divide(i, 2) != i/2 )
				System.out.println("error at "+i);
	}

	/*
	 * Similar to the method used in SquareRoot, this time we measure how many 2 times divisor can
	 * the dividend have. Some little tricks are used such as using negative integers to 
	 * prevent overflow and check divisor bound limit.
	 */
	public static int divide(int dividend, int divisor){
		if( divisor == 1 ) return dividend;
		if( dividend > 0 ) return -divide(-dividend, divisor);
		if( divisor  > 0 ) return -divide(dividend, -divisor);
		if( dividend > divisor ) return 0;
		if( dividend == Integer.MIN_VALUE && divisor == -1 ) return Integer.MAX_VALUE;
		
		int div = divisor, power = 1, quotient = 0;
		while( (div << 1) < 0 && (div << 1) >= dividend ){
			power <<= 1;
			div <<= 1;
		}
		for(; div < 0 && dividend <= divisor; div >>= 1, power >>= 1 )
			if( dividend - div <= 0 ){
				quotient |= power;
				dividend -= div;
			}
		return quotient;
	}
}
