package easy;

public class ValidPerfectSquare {
	/**
	 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
	 * 
	 * Note: Do not use any built-in library function such as sqrt.
	 **/
	public static void main(String[] args) {
	}

	public static boolean isPerfectSqaure(int num) {
		return binarySearch(num);
	}
	
	// Try bitwise, at most 16 iterations
	public static boolean sqrt(int num){
		long ans = 0;
		long bit = 1L << 15;
		while( bit > 0 ){
			ans |= bit;
			long sq = ans * ans;
			if ( sq > num ) ans ^= bit;
			else if ( sq == num ) return true;
			bit >>= 1;
		}
		return ans*ans == num;
	}
	
	// Binary search has faster convergence than newton's method
	public static boolean binarySearch(int num) {
		if ( num < 1 ) return false;
		if ( num == 1 ) return true;
		long left = 1, right = num >> 1;
		
		while ( left <= right ) {
			long mid = left + ( right - left ) / 2;
			long n = mid * mid;
			if ( n > num ) right = mid - 1;
			else if ( n < num ) left = mid + 1;
			else return true;
		}
		
		return false;
	}
	
	// Newton's method
	public static boolean newton(int num){
		if ( num < 1 ) return false;
		if ( num == 1 ) return true;
		long n = num >> 1;
		while ( n * n > num ) {
			n = ( n + num / n ) / 2;
		}
		return ( n * n ) == num;
	}
}
