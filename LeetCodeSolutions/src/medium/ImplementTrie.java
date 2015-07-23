package medium;

import util.TrieNode;

public class ImplementTrie {

	/**
	 * Implement a trie with insert, search, and startsWith methods.
	 * You may assume that all inputs are consist of lower case letters a-z.
	 **/
	public static void main(String[] args) {
		ImplementTrie Trie = new ImplementTrie();
		Trie.insert("a");
		System.out.println(Trie.search("a"));
		System.out.println(Trie.startsWith("a"));
	}

	/*
	 * This implementation is using more hash concept because there is only 26 lower case
	 * letters. It can also be implemented like the B+ tree, which is linked list in nature.
	 */
	private TrieNode root;
	
	public ImplementTrie(){
		root = new TrieNode();
	}
	
	public void insert(String word){
		TrieNode node = root;
		for( char c : word.toCharArray() ){
			if( node.leaf[c-'a'] == null ) node.leaf[c-'a'] = new TrieNode();
			node = node.leaf[c-'a'];
		}
		node.isWord = true;
	}
	
	public boolean search(String word){
		TrieNode node = root;
		for( char c : word.toCharArray() ){
			if( node.leaf[c-'a'] == null ) return false;
			else node = node.leaf[c-'a'];
		}
		return node.isWord;
	}
	
	public boolean startsWith(String prefix){
		TrieNode node = root;
		for( char c : prefix.toCharArray() ){
			if( node.leaf[c-'a'] == null ) return false;
			else node = node.leaf[c-'a'];
		}
		return true;
	}
}
