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

	public TreeNode(Integer[] x){
		val = x[0];
		LinkedList<TreeNode> queue = new LinkedList<>();
		LinkedList<TreeNode> next = new LinkedList<>();
		LinkedList<TreeNode> temp;
		queue.add(this);
		for ( int i = 1, j = 1, k = 1; j < x.length; ++i ){
			k += 1<<i;
			while ( j < k && j < x.length ) {
				TreeNode node = queue.pop();
				node.left = x[j] == null? null: new TreeNode(x[j]);
				node.right = x[j+1] == null? null: new TreeNode(x[j+1]);
				next.add(node.left);
				next.add(node.right);
				j+=2;
			}
			temp = queue;
			queue = next;
			next = temp;
			next.clear();
		}
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