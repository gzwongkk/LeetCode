package easy;

public class IntegerReplacement {
	/**
	 * Given a positive integer n and you can do operations as follow:
	 * 1. If n is even, replace n with n/2.
	 * 2. If n is odd, you can replace n with either n+1 or n-1.
	 * What is the minimum number of replacements needed for n to become 1?
	 * 
	 * Input: 8, Output: 3, 8->4->2->1
	 * Input: 7, Output: 4, 7->6->3->2->1 or 7->8->4->2->1
	 **/
	public static void main(String[] args) {
		System.out.println(integerReplacement(8));
		System.out.println(integerReplacement(7));
		System.out.println(integerReplacement(3));
		System.out.println(integerReplacement(10000));
		System.out.println(integerReplacement(65535));
		System.out.println(integerReplacement(2147483647));
	}

	/*
	 * Recursion (Tree search) may have a lot overhead. Bitwise operations are preferred.
	 * In binary point of view, dividing by two means shifting to the right.
	 * If the +1 or -1 operation can eliminate more 1s in binary form, it should be chosen.
	 * The only case that +1 can eliminate more 1s is that (N+1)/2 is even.
	 * However, 3 is a special case that cannot fit in this rule.
	 */
	public static int integerReplacementf(int n) {
		if ( n == 1 ) return 0;
		if ( n == Integer.MAX_VALUE ) return 32;
		if ( (n&1) == 0 ) return integerReplacement(n/2)+1;
		return Math.min(integerReplacement(n+1)+1, integerReplacement(n-1)+1);
	}

	public static int integerReplacement(int n) {
		long N = n;
		int num = 0;
		while ( N != 1 && N != 3 ) {
			if ( (N & 1) == 0 ) 			// N is even
				N >>= 1;
			else if ( ((N+1)>>1 & 1) == 0 )	// (N+1)/2 is even
				N++;
			else 
				N--;
			num++;
		}
		if ( N == 3 ) num += 2;
		return num;
	}
}
