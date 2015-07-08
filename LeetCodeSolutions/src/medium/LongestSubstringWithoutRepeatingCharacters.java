package medium;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	/**
	 * Given a string, find the length of the longest substring without
	 * repeating characters. For example, the longest substring without
	 * repeating letters for "abcabcbb" is "abc", which the length is 3.
	 * For "bbbbb" the longest substring is "b", with the length of 1.
	 **/

	public static void main(String[] args) {
		String input = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ ";
		System.out.println(lengthOfLongestSubstring(input));
	}
	
	/*
	 * The solution uses a window to check while traversing. 2 pointers are used.
	 * Whenever a new character has existed in window, its maximum is reached.
	 * New window begins at the old repeated character+1 to new repeated character.
	 * Since HashMap has O(1) retrieve time, O(n) solution is achieved.
	 */
	
	public static int lengthOfLongestSubstring(String s) {
        int max = 0, n = s.length();
		HashMap<Character, Integer> bucket = new HashMap<Character, Integer>();
		for( int i = 0, j = 0; i < n; ++i){
			if( bucket.containsKey(s.charAt(i)) ){
				j = Math.max(j, bucket.get(s.charAt(i))+1);
			}
			bucket.put(s.charAt(i), i);
			max = Math.max(max, i-j+1);
		}
		return max;
    }

	//Another version is to use an array instead of a HashMap, but somehow it exceeds time limit.
	//But this version is faster in C++. It reveals that making any object in Java is slower than in C++.
	public static int lengthOfLongestSubstringArray(String s){
		int max = 0, i = 0, j = 0, n = s.length();
		boolean[] bucket = new boolean[256];
		while( j < n ){
			if( bucket[s.charAt(j)] ){
				max = Math.max(max, j-i);
				while( s.charAt(i) != s.charAt(j) ){
					bucket[s.charAt(i)] = false;
					++i;
				}
				++i;
			} else {
				bucket[s.charAt(j)] = true;
			}
			++j;
		}
		return (max>n-i)?max:n-i;
	}
}
