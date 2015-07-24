package medium;

public class PowDouble {

	/**
	 * Implement pow(x,n).
	 **/
	public static void main(String[] args) {
		for( int i = -10; i < 11; ++i )
			System.out.println(myPow(2, i));
	}

	/*
	 * Applying binary search or merge in merge sort to get O(log n) time.
	 * More precisely, this is actually the IEEE standard for the data type "double".
	 */
	public static double myPow(double x, int n){
		double ans = 1, base = n > 0? x: 1/x;
		n = n > 0? n: -n;
		while( n > 0 ){
			if( n % 2 == 1 ) ans *= base;
			n >>= 1;
			base *= base;
		}
		return ans;
	}
}
