package easy;

public class ReverseInteger {
	
	/**
	 * Reverse digits of an integer.
	 * Example1: x = 123, return 321
	 * Example2: x = -123, return -321
	 **/

	public static void main(String[] args) {
		int input = 123;
		System.out.println(reverse(input));
	}
	
	/*
	 * It is better to use a larger container i.e. long to hold the value so that
	 * overflow can be easily detected. Moreover, negative value actually won't change
	 * its value in division, so there is actually no need to worry about it.
	 */
	public static int reverse(int x) {
        long ans = 0;
        while( x != 0 ){
            ans = ans*10+x%10;
            x /= 10;
        }
        return (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)? 0:(int) ans;
    }

	/*
	 * another version that uses int only, use value checking for overflow detection
	 */
	public static int reverseValueCheck(int x){
		int ans = 0;
		boolean negative = false;
		if( x < 0 ) negative = true;
		x = Math.abs(x);
		while( x > 0 ){
			if( ans*10/10 != ans )	return 0;	//overflow checking
			ans *= 10;
			ans += x%10;
			x /= 10;
		}
		return negative?-ans:ans;
	}
}
