package easy;

public class RepeatedSubstringPattern {
	/**
	 * Given a non-empty string check if it can be constructed by taking a substring of it and appending 
	 * multiple copies of the substring together. You may assume the given string consists of lowercase 
	 * English letters only and its length will not exceed 10000.
	 * Example 1:
	 * Input: "abab"
	 * Output: True
	 * Explanation: It's the substring "ab" twice.
	 * 
	 * Example 2:
	 * Input: "aba"
	 * Output: False
	 * 
	 * Example 3:
	 * Input: "abcabcabcabc"
	 * Output: True
	 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
	 **/
	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("abab"));
		System.out.println(repeatedSubstringPattern("ababcab"));
		System.out.println(repeatedSubstringPattern("abcabcabcabc"));
		System.out.println(repeatedSubstringPattern("abaababaab"));
	}

	/*
	 * 1. Check every possibility ~26ms
	 * 2. RegEx ~140ms
	 * 3. KMP check ~17ms
	 * 4. Substring check ~70ms
	 */
	public static boolean repeatedSubstringPattern(String s) {
		return repeatedSubstringPatternKMP(s);
	}
	
	public static boolean repeatedSubstringPatternBruteForce(String s) {
		char[] str = s.toCharArray();
		Pattern: for ( int i = str.length/2; i >= 1; --i ) {
			if ( str.length%i == 0 ) {
				int k = str.length/i;
				for ( int j = 1; j < k; ++j ) {
					for ( int m = 0; m < i; ++m ) {
						if ( str[m] != str[j*i+m] ) continue Pattern;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	public static boolean repeatedSubstringPatternRegEx(String s) {
        return s.matches("(.+)\\1+");
    }

	/*
	 * Build the KMP table. If a pattern is repeated, there must be at least two identical prefixes.
	 * Time and Space : O(n)
	 */
	public static boolean repeatedSubstringPatternKMP(String s) {
		char[] str = s.toCharArray();
		int i = 1, j = 0;
		int[] kmp = new int[str.length+1];
		while ( i < str.length ) {
			if ( str[i] == str[j] ) kmp[++i] = ++j;
			else if ( j > 0 ) j = kmp[j];
			else ++i;
		}
		return (kmp[str.length] != 0) && (str.length % (str.length - kmp[str.length]) == 0); 
	}

	/*
	 * Suppose string S consists of two pattern P, s.t. S = PP.
	 * Repeat S to have S1 = SS = PPPP
	 * Remove the first and last character in S1, so that S2 = ss = pPPp
	 * If we can still find PP = S in S2, S is repeated.
	 */
	public static boolean repeatedSubstringPatternSubstring(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append(s.substring(1));
		sb.append(s.substring(0, s.length()-1));
		return sb.toString().contains(s);
	}
}
