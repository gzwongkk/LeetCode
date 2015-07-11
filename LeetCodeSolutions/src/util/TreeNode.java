package util;

import java.util.LinkedList;

public class TreeNode{
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
	public TreeNode(int x, TreeNode l, TreeNode r){
		val = x;
		left = l;
		right = r;
	}
	@Override
	public String toString(){
		LinkedList<TreeNode> root = new LinkedList<TreeNode>();
		LinkedList<TreeNode> leaf = new LinkedList<TreeNode>();
		root.add(this);
		String output = "";
		while( !root.isEmpty() ){
			for( TreeNode t : root ){
				if( t.left != null )
					leaf.add(t.left);
				if( t.right != null )
					leaf.add(t.right);
				output += t.val + " ";
			}
			root.clear();
			LinkedList<TreeNode> temp = leaf;
			leaf = root;
			root = temp;
			output += '\n';
		}
		return output;
	}
}