package easy;


public class FactorialTrailingZeroes {

	/**
	 * Given an integer n, return the number of trailing zeroes in n!.
	 * Note: Your solution should be in logarithmic time complexity.
	 **/
	public static void main(String[] args) {
		int n = 2147483647;
		System.out.println(trailingZeroes(n));
		System.out.println(trailingZeroesBadLoop(n));
		System.out.println(trailingZeroesRecursive(n));
		printRuntime();
	}

	public static void printRuntime(){
		long startTime, endTime;
		int n = 2147483647;
		startTime = System.nanoTime();
		trailingZeroes(n);
		endTime = System.nanoTime();
		System.out.println(endTime - startTime);

		startTime = System.nanoTime();
		trailingZeroesBadLoop(n);
		endTime = System.nanoTime();
		System.out.println(endTime - startTime);

		startTime = System.nanoTime();
		trailingZeroesRecursive(n);
		endTime = System.nanoTime();
		System.out.println(endTime - startTime);
	}

	/*
	 * Great explanation can be found online.
	 * 10 is a product of 2 and 5. Since even numbers outnumber multiples of 5, we can simply keep
	 * track number of 5 multiples and get jobs done. Notice that 25*2=50*2=100 which gives 2 trailing
	 * zeroes. This means the multiples of power of 5 increases the answer by the value of power.
	 */
	public static int trailingZeroes(int n){
		int ans = 0;
		for(; n > 0 ; n /= 5)
			ans += n/5;
		return ans;
	}

	/**
	 * This implementation of loop is even worse than recursion.
	 * 1. the division is getting more complicated during runtime.
	 * 2. the multiplication is also getting more complicated.
	 * 3. casting between int and long.
	 */
	public static int trailingZeroesBadLoop(int n){
		int ans = 0;
		for( long i = 5; i <= n ; i *= 5 )
			ans += n/i;
		return ans;
	}

	public static int trailingZeroesRecursive(int n){
		return (n < 5  ? 0 : (n/5 + trailingZeroesRecursive(n/5)));
	}
}
