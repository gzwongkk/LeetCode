package easy;

public class StringToInteger {

	/**
	 * Implement atoi to convert a string to an integer.
	 * Hint: Carefully consider all possible input cases.
	 * If you want a challenge, please do not see below and ask youself what are the possible input cases.
	 * Notes: It is intended for this problem to be specified vaguely. You are responsible to gather all the input requirements up front.
	 * 
	 **/

	public static void main(String[] args) {
		String input = "53216987432498465";
		System.out.println(myAtoi(input));
	}

	/*
	 * consider the following cases: 1) space 2) + or - 3) termination 4) overflow
	 * Overflow detection should be implemented twice, including both methods as in ReverseInteger
	 * It is because for string, the input has no constraint in which it might not exist a larger container.
	 */

	public static int myAtoi(String str){
		if( str == null )	return 0;
		char c[] = str.toCharArray();
		int i = 0, ans = 0;
		while( i < c.length ){
			if(c[i] == ' ')
				++i;
			else
				break;
		}

		if( i == c.length )
			return 0;
		boolean positive = true;
		if( c[i] == '-' ){
			positive = false;
			++i;
		} else if ( c[i] == '+' ) ++i;
		while( i < c.length ){
			if ( c[i] < '0' || c[i] > '9' ){
				break;
			} else {
				if( ans *10/10 != ans )
					return positive?Integer.MAX_VALUE:Integer.MIN_VALUE;
				ans = ans*10 + c[i++] - '0';
			}
		}
		if(!positive)	ans = -ans;
		if(positive && ans < 0)	return Integer.MAX_VALUE;
		else if(!positive && ans > 0)	return Integer.MIN_VALUE;
		return ans;
	}
}
