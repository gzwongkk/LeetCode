package easy;

import util.TreeNode;

public class DiameterOfBinaryTree {
	/**
	 * Given a binary tree, you need to compute the length of the diameter of the tree. 
	 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
	 * This path may or may not pass through the root.
	 **/
	public static void main(String[] args) {
		System.out.println(diameterOfBinaryTree(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3))));
	}

	/*
	 * In order for root to be counted as the diameter, the path cannot cross in between your subtrees.
	 * path is either completely from left or right or use root as bridge to cross the two. 
	 */
	public static int max = -1;
	public static int diameterOfBinaryTree(TreeNode root) {
		if ( root == null ) return 0;
		Depth(root);
		return max;
	}
	
	public static int Depth(TreeNode root) {
		if ( root == null ) return 0;
		int left = Depth(root.left);
		int right = Depth(root.right);
		max = Math.max(left+right, max);
		return Math.max(left+1, right+1);
	}
	
	public static int diameterOfBinaryTreeRecursive(TreeNode root) {
		if ( root == null ) return 0;
		return Math.max(Math.max(diameterOfBinaryTreeRecursive(root.left), diameterOfBinaryTreeRecursive(root.right)), 
				diameterOfBinaryTreeOneSide(root.left)+diameterOfBinaryTreeOneSide(root.right));
	}
	
	public static int diameterOfBinaryTreeOneSide(TreeNode root) {
		if ( root == null ) return 0;
		return Math.max(diameterOfBinaryTreeOneSide(root.left), diameterOfBinaryTreeOneSide(root.right))+1;
	}
}
