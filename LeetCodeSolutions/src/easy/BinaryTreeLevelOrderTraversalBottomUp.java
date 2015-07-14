package easy;

import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

public class BinaryTreeLevelOrderTraversalBottomUp {

	/**
	 * Given a binary tree, return the bottom-up level order traversal of its nodes' values, 
	 * (i.e., from left to right, level by level from leaf to root).
	 * For example, Given binary tree {3,9,20,#,#,15,7},
		    3
		   / \
		  9  20
		    /  \
		   15   7
	 * return its bottom-up level order traversal as:
		[
		  [15,7],
		  [9,20],
		  [3]
		]
	 **/
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3,new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		for( List<Integer> list : levelOrderBottom(root) ){
			for( Integer i : list )
				System.out.print(i + " ");
			System.out.println();
		}
	}

	/*
	 * The advantage of using LinkedList in Java is that it can be easily changed in a 
	 * stack or a queue. In this problem, the change determines the returning order, either 
	 * in bottom-up or top-down.
	 */
	public static List<List<Integer>> levelOrderBottom(TreeNode root){
		LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		if( root != null ) queue.add(root);
		while( !queue.isEmpty() ){
			list.push(new LinkedList<Integer>());
			for( int i = queue.size(); i > 0; --i ){
				list.peek().add(queue.peek().val);
				if( queue.peek().left != null ) queue.add(queue.peek().left);
				if( queue.peek().right != null ) queue.add(queue.peek().right);
				queue.poll();
			}
		}
		return list;
	}
}
