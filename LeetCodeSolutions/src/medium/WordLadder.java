package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	/**
	 * Given two words ( beginWord and endWord ), and a dictionary, find the length of shortest 
	 * transformation sequence from beginWord to endWord, such that:
	 * 1. Only one letter can be changed at a time
	 * 2. Each intermediate word must exist in the dictionary
	 * For example, Given
	 * start = "hit"
	 * end   = "cog"
	 * dict  = {"hot", "dot", "dog", "lot", "log"}
	 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
	 * 
	 *  Note:
	 *  Return 0 if there is no such transformation sequence.
	 *  All words have the same length.
	 *  All words contain only lower case alphabetic characters.
	 **/
	public static void main(String[] args) {
		Set<String> wordDict = new HashSet<>();
		wordDict.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log"));
		System.out.println(ladderLengthGeneralBFS("hit", "cog", wordDict));
	}

	/*
	 * This problem contraints the word to be all lower-case character, which most likely means it requires
	 * you to do stupid constant(26) time operations to the strings. Doing a graph construction, which is
	 * more general, got Time Limit Exception because it is O(n^2) rather than O((26*n)^2).
	 */
	public static int ladderLength(String beginWord, String endWord, Set<String> wordDict){
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		wordDict.remove(beginWord);
		int ans = 1;
		while( !queue.isEmpty() ){
			for( int count = queue.size(); count > 0; --count ){
				String word = queue.poll();
				StringBuilder altWord = new StringBuilder(word);
				for( int i = 0; i < word.length(); ++i ){
					char w = altWord.charAt(i);
					for( char c = 'a'; c <= 'z'; ++c ){
						if( w == c ) continue;
						altWord.setCharAt(i, c);
						if( altWord.toString().equals(endWord) ) return ans+1;
						if( wordDict.contains(altWord.toString()) ){
							queue.add(altWord.toString());
							wordDict.remove(altWord.toString());
						}
						altWord.setCharAt(i, w);
					}
				}
			}
			++ans;
		}
		return 0;
	}
	
	public static int ladderLengthGeneralBFS(String beginWord, String endWord, Set<String> wordDict){
		HashMap<String, List<String>> dict = new HashMap<>();
		wordDict.addAll(Arrays.asList(beginWord, endWord));
		for( String word : wordDict ){
			dict.put(word, new ArrayList<String>());
			for( String tran : wordDict ){
				int diff = 0;
				for( int i = 0; i < word.length(); ++i )
					if( word.charAt(i) != tran.charAt(i) && diff++ == 1 ) break;
				if( diff == 1 ) dict.get(word).add(tran);
			}
		}
		
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		int ans = 1;
		while( !queue.isEmpty() ){
			for( int count = queue.size(); count > 0; --count ){
				String word = queue.poll();
				if( word.equals(endWord) ) return ans;
				if( dict.containsKey(word) ){
					for( String subWord : dict.get(word) ) queue.add(subWord);
					dict.remove(word);
				}
			}
			++ans;
		}
		return 0;
	}
}
