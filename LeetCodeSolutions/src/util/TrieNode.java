package util;

public class TrieNode {
	public char val;
	public TrieNode[] leaf = new TrieNode[26];
	public boolean isWord = false;
	
	public TrieNode(){
		
	}
	public TrieNode(char val){
		this.val = val;
	}
}
