package easy;

import java.util.Arrays;

public class ValidAnagram {

	/**
	 * Given two strings s and t, write a function to determine if t is an anagram
	 * of s. For example,
	 * s = "anagram", t = "nagaram", return true.
	 * s = "rat", t = "car", return false.
	 * 
	 * Note: You may assume the string contains only lowercase alphabets.
	 **/
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));
		System.out.println(isAnagram("listen", "silent"));
	}

	/*
	 * Anagrams are the same when it is sorted. So the two solutions will be sorting
	 * the string and check equivalence, or modifying bucket sort to directly check
	 * equivalence on the fly.
	 */
	public static boolean isAnagram(String s, String t){
		int[] buckets = new int[26];
		for( char c : s.toCharArray() ) ++buckets[c-'a'];
		for( char c : t.toCharArray() ) --buckets[c-'a'];
		for( int i : buckets ) if( i != 0 ) return false;
		return true;
	}
	
	public static boolean isAnagramSort(String s, String t){
		char[] cs = s.toCharArray();
		char[] ct = t.toCharArray();
		Arrays.sort(cs);
		Arrays.sort(ct);
		return Arrays.equals(cs, ct);
	}
}
