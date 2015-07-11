package easy;

import java.util.HashMap;

public class IsomorphicString {

	/**
	 * Given two strings s and t. determine if they are isomorphic.
	 * Two strings are isomorphic if the characters in s can be replaced to get t.
	 * All occurrences of a character must be replaced with another character while
	 * preserving the order of characters. No two characters may map to the same character
	 * but a character may map to itself. For example,
	 * Given "egg", "add" return true.
	 * Given "foo", "bar" return false.
	 * Given "paper", "title return true.
	 * Note: You may assume both s and t have the same length.
	 **/

	public static void main(String[] args) {
		String s = "paper", t = "title";
		System.out.println(isIsomorphic(s,t));
	}

	/*
	 * Use HashMap to easily achieve the result. containsKey and containsValue works
	 * perfectly fine for this problem. It could be sped up using two HashMaps.
	 */
	public static boolean isIsomorphic(String s, String t){
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		int size = s.length();
		for(int i = 0; i < size; ++i){
			char si = s.charAt(i), ti = t.charAt(i);
			if( map.containsKey(si) ){
				if( map.get(si) != ti )	return false;
			} else {
				if( map.containsValue(ti) )	return false;
				else map.put(si, ti);
			}
		}
		return true;
	}
}
