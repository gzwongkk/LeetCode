package medium;

import util.TrieNode;

public class AddSearchWordDataStructure {

	/**
	 * Design a data structure that supports the following two operations:
	 * void addWord(word)
	 * boolean search(word)
	 * 
	 * search(word) can search a literal word or a regular expression string containing only
	 * letters a-z or '.' . A '.' means it can represent any one letter. For example,
	 * addWord("bad")
	 * addWord("dad")
	 * addWord("mad")
	 * search("pad") -> false
	 * search("bad") -> true
	 * search(".ad") -> true
	 * search("b..") -> true
	 * Note: You may assume that all words are consist of lower case letters a-z.
	 **/
	public static void main(String[] args) {
		AddSearchWordDataStructure dictionary = new AddSearchWordDataStructure();
		dictionary.addWord("bad");
		dictionary.addWord("dad");
		dictionary.addWord("mad");
		System.out.println(dictionary.search("pad"));
		System.out.println(dictionary.search("bad"));
		System.out.println(dictionary.search(".ad"));
		System.out.println(dictionary.search("b.."));
	}

	/*
	 * This is a Breadth First Search in tree. Any '.' reset the node as the root in "ImplementTrie".
	 */
	private TrieNode root;
	
	public AddSearchWordDataStructure(){
		 root = new TrieNode();
	}
	
	public void addWord(String word){
		TrieNode node = root;
		for( char c : word.toCharArray() ){
			if( node.leaf[c-'a'] == null ) node.leaf[c-'a'] = new TrieNode();
			node = node.leaf[c-'a'];
		}
		node.isWord = true;
	}
	
	public boolean search(String word){
		return searchRecursive(word, root);
	}
	
	private boolean searchRecursive(String word, TrieNode node){
		char[] wordArray = word.toCharArray();
		for( int i = 0; i < wordArray.length; ++i ){
			if( wordArray[i] != '.' ){
				node = node.leaf[wordArray[i]-'a'];
				if( node == null ) return false;
			} else {
				for( int j = 0; j < node.leaf.length; ++j ){
					if( node.leaf[j] != null && searchRecursive(word.substring(i+1, wordArray.length), node.leaf[j])) return true;
				}
				return false;
			}
		}
		return node.isWord;
	}
}
