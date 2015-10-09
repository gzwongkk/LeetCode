package easy;
import java.util.*;

public class WordPattern {
	/**
	 * Given a pattern and a string str, find if str follows the same pattern.
	 * Examples:
	 * 1. pattern = "abba", str = "dog cat cat dog" should return true.
	 * 2. pattern = "abba", str = "dog cat cat fish" should return false.
	 * 3. pattern = "aaaa", str = "dog cat cat dog" should return false.
	 * 4. pattern = "abba", str = "dog dog dog dog" should return false.
	 * Note:
	 * 1. pattern contains only lowercase alphabetical letters, and str contains words separated
	 * 		by a single space. Each word in str contains only lowercase alphabetical letters.
	 * 2. Both pattern and str do not have leading or trailing spaces.
	 * 3. Each letter in pattern must map to a word with length that is at least 1.
	 **/
	public static void main(String[] args) {
		System.out.println(wordPattern("abba", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog cat cat fish"));
		System.out.println(wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(wordPattern("abba", "dog dog dog dog"));
	}

	/*
	 * In fact, the map put() method returns the previously associated with the key.
	 * Using non-generic Map together with put() allow inverted checking for real keys.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean wordPattern(String pattern, String str){
		String[] strPattern = str.split(" ");
		if( strPattern.length != pattern.length() ) return false;
		HashMap map = new HashMap();
		for( int i = 0; i < strPattern.length; ++i )
			if( !Objects.equals(map.put(pattern.charAt(i), i), map.put(strPattern[i], i)) )
				return false;
		return true;
	}
}
