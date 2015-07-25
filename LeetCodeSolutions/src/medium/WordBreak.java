package medium;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	/**
	 * Given a string s and a dictionary of words dict, determine if s can be segmented
	 * into a space-separated sequence of one or more dictionary words.
	 * For example, given s = "leetcode", dict = ["leet", "code"].
	 * Return true because "leetcode" can be segmented as "leet code".
	 **/
	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("code");
		wordDict.add("aaaa");
		wordDict.add("aaa");
		System.out.println(wordBreak(s, wordDict));
		s = "aaaaaaa";
		System.out.println(wordBreak(s, wordDict));
	}

	/*
	 * First thought of doing greedy, but that doesn't work as in the above test case.
	 * Then DP is the only way out.
	 */
	public static boolean wordBreak(String s, Set<String> wordDict){
		int size = s.length();
		if( size == 0 ) return false;
		boolean[] dp = new boolean[size+1];
		dp[0] = true;
		for( int i = 1; i <= size; ++i ){
			for( int j = 0; j < i; ++j ){
				if( dp[j] && wordDict.contains(s.substring(j, i))){
					dp[i] = true;
					break;
				}
			}
		}
		return dp[size];
	}
}
