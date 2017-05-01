package easy;

import util.TreeNode;

public class MinimumAbsoluteDifferenceInBST {
	/**
	 * Given a binary search tree with non-negative values, find the minimum absolute difference between 
	 * values of any two nodes.
	 **/
	public static void main(String[] args) {
		System.out.println(getMinimumDifference(new TreeNode(236, new TreeNode(104, null, new TreeNode(227)), new TreeNode(701, null, new TreeNode(911)))));
	}
	
	// In order traversal in BST will create a sorted list of elements.

	public static TreeNode inOrder;
	
	public static int getMinimumDifference(TreeNode root){
		if ( root == null ) return Integer.MAX_VALUE;
		int min = getMinimumDifference(root.left);
		if ( inOrder != null )
			min = Math.min(min, Math.abs(root.val-inOrder.val));
		inOrder = root;
		return Math.min(min, getMinimumDifference(root.right));
	}
}
