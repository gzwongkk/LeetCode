package easy;

import util.TreeNode;

public class SameTree {

	/**
	 * Given two binary trees, write a function to check if they are equal or not.
	 * Two binary trees are considered equal if they are structurally identical and
	 * the nodes have the same value.
	 **/
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1, 
				new TreeNode(2, new TreeNode(3), new TreeNode(4)),
				new TreeNode(2, new TreeNode(4), new TreeNode(3)));
		TreeNode root2 = new TreeNode(1, 
				new TreeNode(2, new TreeNode(3), new TreeNode(4)),
				new TreeNode(2, new TreeNode(4), new TreeNode(3)));
		System.out.println(isSameTree( root1, root2 ));
	}

	/*
	 * Recursion is good in tree traversal.
	 */
	public static boolean isSameTree(TreeNode p, TreeNode q){
		if( p == null || q == null ) return p == q;
		return p.val == q.val && isSameTree( p.left, q.left ) && isSameTree( p.right, q.right );
	}
}
