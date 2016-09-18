package easy;

public class GuessNumberHigherOrLower {
	/**
	 * We are playing the Guess Game. The game is as follows:
	 * I pick a number from 1 to n. You have to guess which number I picked.
	 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
	 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0 ):
	 * -1 : My number is lower
	 *  1 : My number is higher
	 *  0 : Congrats! You got it!
	 *  
	 *  n = 10, I pick 6. Return 6.
	 **/
	public static void main(String[] args) {
		GuessNumberHigherOrLower test = new GuessNumberHigherOrLower(8);
		System.out.println(test.guessNumber(20));
		GuessNumberHigherOrLower test2 = new GuessNumberHigherOrLower(6);
		System.out.println(test2.guessNumber(10));
		GuessNumberHigherOrLower test3 = new GuessNumberHigherOrLower(30);
		System.out.println(test3.guessNumber(30));
	}
	
	private int mN;
	
	public GuessNumberHigherOrLower(int n) {
		mN = n;
	}

	/*
	 * This is Binary search.
	 */
	public int guessNumber(int n) {
		int start = 1, end = n, middle = start+((end-start)>>1);
		int ans = guess(middle);
		while ( ans != 0 ) {
			if ( ans == -1 ) end = middle;
			else start = middle+1;
			middle = start+((end-start)>>1);
			ans = guess(middle);
		}
		return middle;
	}
	
	public int guess(int num) {
		if ( num < mN ) return 1;
		else if ( num > mN ) return -1;
		else return 0;
	}
}
