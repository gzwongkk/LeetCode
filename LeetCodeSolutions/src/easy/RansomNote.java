package easy;

public class RansomNote {
	/**
	 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a 
	 * function that will return true if the ransom note can be constructed from the magazines; otherwise, it will return false.
	 * Each letter in the magazine string can only be used once in your ransom note.
	 * 
	 * You may assume that both strings contain only lowercase letters.
	 * 
	 * canConstruct("a", "b") -> false
	 * canConstruct("aa", "bb") -> false
	 * canConstruct("aa", "aab") -> true
	 **/
	public static void main(String[] args) {
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "bb"));
		System.out.println(canConstruct("aa", "aab"));
		System.out.println(canConstruct("abcdefghijk", "abcdefghijk"));
		System.out.println(canConstruct("aabcdefghijk", "abcdefghijk"));
	}

	/*
	 * Use count and match to achieve O(n) time. Early out by length and negative number check.
	 */
	public static boolean canConstruct(String ransomNote, String magazine) {
		if ( ransomNote.length() > magazine.length() ) return false;
		int[] set = new int[26];
		for ( char c : magazine.toCharArray() )
			set[c-'a']++;
		for ( char c : ransomNote.toCharArray() ) {
			if ( set[c-'a'] == 0 )
				return false;
			set[c-'a']--;
		}
		return true;
	}
}
