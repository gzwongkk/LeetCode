package medium;

public class SquareRoot {

	/**
	 * Implement int sqrt(int x).
	 * Compute and return the square root of x.
	 **/
	public static void main(String[] args) {
		System.out.println(mySqrt(100000));
		System.out.println(sqrt(100000));
	}

	/*
	 * 1) This binary search is slightly different to the normal version, and is quite tricky.
	 * 		It is because the function is returning levels of square root, like 4,5,6,7,8 all
	 * 		return 2. So there must be an extra variable to store this level, while the normal
	 * 		high and low find for x. The extra will be changed only when mid^2 is less than x.
	 * 2) Using long to prevent overflow, it utilizes beautiful binary tricks to build up the
	 * 		solution. Starting from the max value of Integer, it checks whether changing this
	 * 		digit to 1 can fulfill ans^2 > x, which ans is the square root. If not, simply negate
	 * 		it back by using XOR. Genius.
	 * Both function is O(log n), but in fact, since the maximum value of Integer is 32 bit, so we
	 * can also say it is O(log 32) => O(1).
	 */
	public static int mySqrt(int x){
		int low = 1, high = x, ans = 0;
		while( low <= high ){
			int mid = low + ( high - low ) / 2;
			if( mid <= x / mid ){
				low = mid + 1;
				ans = mid;
			}
			else high = mid - 1;
		}
		return ans;
	}
	
	public static int sqrt(int x){
		long ans = 0;
		long bit = 1L << 15;
		while( bit > 0 ){
			ans |= bit;
			if( ans * ans > x ) ans ^= bit;
			bit >>= 1;
		}
		return (int)ans;
	}
}
