package easy;

import java.util.LinkedList;
import java.util.List;
import util.TreeNode;

public class BinaryTreeLevelOrderTraversalTopDown {

	/**
	 * Given a binary tree, return the level order traversal of its nodes'
	 * values. (ie, from left to right, level by level). For example,
	 * Given binary tree {3,9,20,#,#,15,7},
		    3
		   / \
		  9  20
		    /  \
		   15   7
	 * return its level order traversal as:
		[
		  [3],
		  [9,20],
		  [15,7]
		]
	 **/
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3,new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		for( List<Integer> list : levelOrder(root) ){
			for( Integer i : list )
				System.out.print(i + " ");
			System.out.println();
		}
	}

	/*
	 * Use queue to traverse all nodes in required order.
	 */
	public static List<List<Integer>> levelOrder(TreeNode root){
		LinkedList<List<Integer>> tree = new LinkedList<List<Integer>>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		if( root != null ) queue.add(root);
		while( !queue.isEmpty() ){
			tree.add(new LinkedList<Integer>());
			for( int i = queue.size(); i > 0; --i ){
				tree.peekLast().add(queue.peek().val);
				if( queue.peek().left != null ) queue.add(queue.peek().left);
				if( queue.peek().right != null ) queue.add(queue.peek().right);
				queue.poll();
			}
		}
		return tree;
	}
}
