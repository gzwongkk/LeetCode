package easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
	/**
	 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
	 * 
	 * Strings consists of lowercase English letters only and the length of both strings s and p 
	 * will not be larger than 20,100.
	 * 
	 * The order of output does not matter.
	 * 
	 * Example 1:
	 * Input:
	 * s: "cbaebabacd" p: "abc"
	 * 
	 * Output:
	 * [0, 6]
	 * 
	 * Explanation:
	 * The substring with start index = 0 is "cba", which is an anagram of "abc".
	 * The substring with start index = 6 is "bac", which is an anagram of "abc".
	 * 
	 * Example 2:
	 * 
	 * Input:
	 * s: "abab" p: "ab"
	 * 
	 * Output:
	 * [0, 1, 2]
	 * 
	 * Explanation:
	 * The substring with start index = 0 is "ab", which is an anagram of "ab".
	 * The substring with start index = 1 is "ba", which is an anagram of "ab".
	 * The substring with start index = 2 is "ab", which is an anagram of "ab".
	 **/
	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
		System.out.println(findAnagrams("abab", "ab"));
	}

	/*
	 * both ~18ms
	 */
	public static List<Integer> findAnagrams(String s, String p) {
		return slidingWindow(s, p);
	}
	
	public static List<Integer> counting(String s, String p) {
		List<Integer> ans = new ArrayList<Integer>();
		if ( s == null || p == null 
				|| s.length() == 0 || p.length() == 0 || s.length() < p.length() ) return ans;
		
		int[] pattern	= new int[26];
		int[] substring	= new int[26];
		for ( char c : p.toCharArray() ) pattern[c-'a']++;

		int m = s.length(), n = p.length();
		char[] str = s.toCharArray();
		for ( int j = 0; j < n-1; substring[str[j++]-'a']++ );
		for ( int i = 0; i < m-n+1; ++i ) {
			substring[str[i+n-1]-'a']++;
			
			int k = 0;
			while ( k < 26 && substring[k] == pattern[k] ) ++k;
			if ( k == 26 ) ans.add(i);
			
			substring[str[i]-'a']--;
		}
		
		return ans;
	}
	
	/*
	 * A good template for sliding window
	 * The spirit is to maintain a count to all positive values in the pattern.
	 * The only way for pattern to be matched is to have count == 0.
	 */
	public static List<Integer> slidingWindow(String s, String p) {
		List<Integer> ans = new ArrayList<Integer>();
		if ( s == null || p == null 
				|| s.length() == 0 || p.length() == 0 || s.length() < p.length() ) return ans;
		
		int[] pattern = new int[26];
		for ( char c : p.toCharArray() ) pattern[c-'a']++;

		char[] str = s.toCharArray();
		int begin = 0, end = 0, count = p.length();
		while ( end < str.length ) {
			if ( pattern[str[end++]-'a']-- >= 1 ) count--;
			if ( count == 0 ) ans.add(begin);
			if ( end - begin == p.length() && pattern[str[begin++]-'a']++ >= 0 ) count++;
		}
		
		return ans;
	}
}
