package easy;

public class ClimbingStairs {

	/**
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top.
	 **/
	public static void main(String[] args){
		int input = 40;
		System.out.println(climbStairs( input ));
	}

	/*
	 * Fibonacci number requires a DP method to calculate. 
	 * Otherwise, it can be easily stack overflow.
	 */
	public static int climbStairs(int n){
		if( n < 3 ) return n;
		int step1 = 1, step2 = 2;
		for( int i = 2; i < n; ++i ){
			step2 += step1;
			step1 = step2 - step1;
		}
		return step2;
	}
}
