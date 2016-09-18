package easy;

public class FirstUniqueCharacterInAString {
	/**
	 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
	 * 
	 * s = "leetcode" return 0.
	 * s = "loveleetcode" return 2.
	 **/
	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
	}

	/*
	 * Use memory to achieve O(1) time.
	 */
	public static int firstUniqChar(String s){
		int[] set = new int[26];
		char[] str = s.toCharArray();
		for ( char c : str ) 
			set[c-'a']++;
		for ( int i = 0; i < str.length; ++i )
			if ( set[str[i]-'a'] == 1 ) return i;
		return -1;
	}
}
