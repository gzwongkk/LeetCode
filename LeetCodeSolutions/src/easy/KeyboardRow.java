package easy;

import java.util.HashMap;
import java.util.Vector;
import java.util.stream.Stream;

public class KeyboardRow {
	/**
	 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of 
	 * American keyboard.
	 **/
	public static void main(String[] args) {
		for(String s : findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}))
			System.out.println(s);
		
		for(String s : findWords(new String[]{"asdfghjkl","qwertyuiop","zxcvbnm"}))
			System.out.println(s);
	}

	/* 
	 * Use hashing to get O(log n) check
	 */
	public static String[] findWords(String[] words) {
		String[] rows = new String[]{"qwertyuiop", "asdfghkjl", "zxcvbnm"};
		HashMap<Character, Integer> keys = new HashMap<>();
		for ( int i = 0; i < rows.length; ++i ) {
			for ( char c : rows[i].toCharArray() ) {
				keys.put(c, i);
			}
		}
		
		Vector<String> ans = new Vector<>();
		Loop: for ( String word : words ) {
			if ( word.isEmpty() ) continue;
			int index = keys.get(Character.toLowerCase(word.charAt(0)));
			for ( char c : word.toCharArray() ) {
				if ( index != keys.get(Character.toLowerCase(c)) ) continue Loop;
			}
			ans.add(word);
		}
		return ans.toArray(new String[ans.size()]);
	}
	
	// Solution by lixx2100 on LeetCode discussion. Good demonstration of new syntax in Java 8
	public static String[] findWordsOneLine(String[] words) {
		return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
	}
}
