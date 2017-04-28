package easy;

public class DetectCapital {
	/**
	 * Given a word, you need to judge whether the usage of capitals in it is right or not.
	 * We define the usage of capitals in a word to be right when one of the following cases holds:
	 * 	1. All letters in this word are capitals, like "USA".
	 * 	2. All letters in this word are not capitals, like "leetcode".
	 * 	3. Only the first letter in this word is capital if it has more than one letter, like "Google".
	 * Otherwise, we define that this word doesn't use capitals in a right way.
	 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
	 **/
	public static void main(String[] args) {
		System.out.println(detectCapitalUse("USA"));
		System.out.println(detectCapitalUse("FlaG"));
		System.out.println(detectCapitalUse("leetcode"));
		System.out.println(detectCapitalUse("Google"));
	}

	/*
	 * Complicated but should be the fastest ~30ms because it has early exit and visit one branch in the decision tree only
	 */
	public static boolean detectCapitalUse(String word) {
		char[] w = word.toCharArray();
		if ( w[0] < 'a' ) {	// Upper case
			if ( w.length == 1 ) return true;
			else {
				if ( w[1] < 'a' ) {
					for ( int i = 2; i < w.length; ++i )
						if ( w[i] >= 'a' ) return false;
					return true;
				} else {
					for ( int i = 2; i < w.length; ++i )
						if ( w[i] < 'a' ) return false;
					return true;
				}
			}
		} else {
			for ( int i = 1; i < w.length; ++i ) {
				if ( w[i] < 'a' ) return false;
			}
			return true;
		}
	}
	
	// elegant but much slower ~47ms because all possibilities need to be checked.
	public static boolean detectCapitalUseRegularExpression(String word) {
		return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
	}
}
