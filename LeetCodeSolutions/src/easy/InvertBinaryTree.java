package easy;

import util.TreeNode;

public class InvertBinaryTree {
	/**
	 * Invert a binary tree.
			 4
		   /   \
		  2     7
		 / \   / \
		1   3 6   9

	 * to

		     4
		   /   \
		  7     2
		 / \   / \
		9   6 3   1
	 * Trivia:
	 * This problem was inspired by this original tweet by Max Howell:
	 * 		Google: 90% of our engineers use the software you wrote (homebrew), but you
	 * 		can't invert a binary tree on a whiteboard so fuck off.
	 **/

	public static void main(String[] args) {
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(9);
		TreeNode n2 = new TreeNode(2,n4,n5);
		TreeNode n3 = new TreeNode(7,n6,n7);
		TreeNode n1 = new TreeNode(4,n2,n3);
		System.out.println(n1);
		invertTree(n1);
		System.out.println(n1);
	}

	public static TreeNode invertTree(TreeNode root){
		if(root == null) return null;
		TreeNode temp = root.left;
		root.left = (root.right == null)?null:invertTree(root.right);
		root.right = (temp == null)?null:invertTree(temp);
		return root;
	}
}
