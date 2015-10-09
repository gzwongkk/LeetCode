package easy;

public class UglyNumber {
	/**
	 * Write a program to check whether a given number is an ugly number.
	 * Ugly numbers are positive numbers whose prime factors only, include 2,3,5.
	 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
	 * Note that 1 is typically treated as an ugly number.
	 **/
	public static void main(String[] args) {
		System.out.println(isUgly(6));
		System.out.println(isUgly(8));
		System.out.println(isUgly(14));
	}

	/*
	 * Exploit all factors from [2,5] and check if anything lefts. 
	 * We can use simple for loop because '2' can handle all '4' factors.
	 */
	public static boolean isUgly(int num){
		for( int i = 2; i < 6 && num > 0; ++i )
			while( num % i == 0 )
				num /= i;
		return num == 1;
	}
}
