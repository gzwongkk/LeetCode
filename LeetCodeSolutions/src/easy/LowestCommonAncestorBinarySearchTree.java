package easy;

import util.TreeNode;

public class LowestCommonAncestorBinarySearchTree {

	/**
	 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
	 * According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between two
	 * nodes v and w as the lowest node in T that has both v and w as descendants ( where we allow a node to 
	 * be a descendant of itself)."
		        _______6______
		       /              \
		    ___2__          ___8__
		   /      \        /      \
		   0      _4       7       9
		         /  \
		         3   5
	 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of
	 * nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
	 **/
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6,new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5)))
				, new TreeNode(8, new TreeNode(7), new TreeNode(9)));
		System.out.println(lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val);
	}

	/*
	 * This is a binary search tree, so the value on the left must be smaller than that on right.
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		while( (root.val-p.val) * (root.val-q.val) > 0 )
			root = p.val < root.val ? root.left : root.right; 
		return root;
	}
}
