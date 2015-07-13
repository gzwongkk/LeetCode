package easy;

import java.util.LinkedList;

import util.TreeNode;

public class MinimumDepthofBinaryTree {

	/**
	 * Given a binary tree, find its minimum depth.
	 * The minimum depth is the number of nodes along the shortest path
	 * from the root node down to the nearest leaf node.
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
		System.out.println(minDepth(root));
	}

	/*
	 * Breadth First Search works best in this problem.
	 */
	public static int minDepth(TreeNode root){
		if( root == null ) return 0;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int count = 0;
		while( !queue.isEmpty() ){
			++count;
			for( int i = queue.size(); i > 0; --i ){
				TreeNode left = queue.peek().left, right = queue.peek().right;
				if( left == null && right == null ) return count;
				if( left != null) queue.add(left);
				if( right != null) queue.add(right);
				queue.poll();
			}
		}
		return count;
	}
}
