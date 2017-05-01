package easy;

public class PerfectNumber {
	/**
	 * We define the Perfect Number is a positive integer that is equal to the 
	 * sum of all its positive divisors except itself.
	 * 
	 * Now, given an integer n, write a function that returns true when it is a perfect 
	 * number and false when it is not.
	 **/
	public static void main(String[] args) {
		System.out.println(checkPerfectNumber(28));
	}

	public static boolean checkPerfectNumber(int num) {
		if ( num == 1 ) return false;
		int sum = 1;
		for ( int i = 2; i < Math.sqrt(num); ++i ) {
			if ( num % i == 0 ) sum += i + ( num / i );
		}
		return sum == num;
	}
}
