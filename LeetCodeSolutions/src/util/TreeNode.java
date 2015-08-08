package util;

import java.util.LinkedList;
import java.util.Queue;

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
		Queue<TreeNode> root = new LinkedList<TreeNode>();
		root.add(this);
		StringBuilder output = new StringBuilder();
		while( !root.isEmpty() ){
			for( int count = root.size(); count > 0; --count ){
				if( root.peek().left != null )
					root.add(root.peek().left);
				if( root.peek().right != null )
					root.add(root.peek().right);
				output.append(root.poll().val + " ");
			}
			output.append('\n');
		}
		return output.toString();
	}
}