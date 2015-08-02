package medium;

public class DecodeWays {

	/**
	 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
	 * 'A' -> 1
	 * 'B' -> 2
	 * ...
	 * 'Z' -> 26
	 * Given an encoded message containing digits, determine the total number of ways to decode it.
	 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12). The
	 * number of ways decoding "12" is 2.
	 **/
	public static void main(String[] args) {
		System.out.println(numDecodings("12"));
		System.out.println(numDecodings("122"));
		System.out.println(numDecodings("1221"));
		System.out.println(numDecodings("12212"));
		System.out.println(numDecodings("122121"));
	}

	/*
	 * This problem cannot ignore the '0' character, thus there are three cases in DP.
	 * And we know that decoding "requires" bottom-up approach. O(n) time, O(1) space.
	 */
	public static int numDecodings(String s){
		char[] str = s.toCharArray();
		if( str.length == 0 ) return 0;
		int DP_i = str[str.length-1] != '0'? 1: 0, DP_j = 1;
		for( int i = str.length-2; i >= 0 ; --i ){
			if( str[i] == '0' ){
				DP_j = DP_i;
				DP_i = 0;
			} else if ((str[i]-'0')*10+str[i+1]-'0' <= 26 ){
				DP_i += DP_j;
				DP_j = DP_i - DP_j;
			} else DP_j = DP_i;
		}
		return DP_i;
	}
}
