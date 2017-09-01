package easy;

import java.util.Stack;

import util.TreeNode;

public class TwoSumIV {
	/**
	 * Given a Binary Search Tree and a target number, 
	 * return true if there exist two elements in the BST such that their sum is equal to the given target.
	 * 
	 * Example 1:
		Input: 
		    5
		   / \
		  3   6
		 / \   \
		2   4   7
		
		Target = 9
		
		Output: True
		Example 2:
		Input: 
		    5
		   / \
		  3   6
		 / \   \
		2   4   7
		
		Target = 28
		
		Output: False
	 **/
	public static void main(String[] args) {
		System.out.println(findTarget(new TreeNode(new Integer[]{5,3,6,2,4,null,7}), 9));
		System.out.println(findTarget(new TreeNode(new Integer[]{5,3,6,2,4,null,7}), 28));
		System.out.println(findTarget(new TreeNode(new Integer[]{2,1,3}), 4));
	}

	public static boolean findTarget(TreeNode root, int k) {
		if ( root == null ) return false;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while ( !stack.isEmpty() ) {
			TreeNode node = stack.pop();
			if ( node.left != null ) stack.add(node.left);
			if ( node.right != null ) stack.add(node.right);
			int target = k-node.val;
			if ( target == node.val ) continue;
			node = root;
			while ( node != null ) {
				if ( target < node.val ) node = node.left;
				else if ( target > node.val ) node = node.right;
				else return true;
			}
		}
		
		return false;
	}
}
