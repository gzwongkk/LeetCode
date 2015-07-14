package easy;

import java.util.Stack;

import util.TreeNode;

public class SymmetricTree {

	/**
	 * Given a binary tree, check whether it is a mirror to itself ( symmetric around its center ).
	 * For example, this binary tree is symmetric:
		    1
		   / \
		  2   2
		 / \ / \
		3  4 4  3
	 * But the following is not:
		    1
		   / \
		  2   2
		   \   \
		   3    3
	 **/
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1, 
				new TreeNode(2, new TreeNode(3), new TreeNode(4)),
				new TreeNode(2, new TreeNode(4), new TreeNode(3)));
		System.out.println(isSymmetric(root1));

		TreeNode root2 = new TreeNode(1, 
				new TreeNode(2, null, new TreeNode(3)),
				new TreeNode(2, null, new TreeNode(3)));
		System.out.println(isSymmetric(root2));
	}

	/*
	 * Recursive seems to be the best solution. Iterative is just manually create a function stack, which is not good in performance.
	 * In order traversal can also work, similar to the toString method in TreeNode. But be careful about
	 * empty nodes. Null nodes should be treated as valid nodes in this solution since the order of nodes matter.
	 */
	public static boolean isSymmetric(TreeNode root){
		return root == null || isSymmetricRecursive(root.left, root.right);
	}

	public static boolean isSymmetricRecursive(TreeNode left, TreeNode right){
		if( left == null || right == null ) return left == right;
		return left.val == right.val && isSymmetricRecursive(left.left, right.right) && isSymmetricRecursive(left.right,  right.left);
	}

	public static boolean isSymmetricIterative(TreeNode root){
		if( root == null ) return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode left, right;
		stack.push(root.left);
		stack.push(root.right);
		while( !stack.isEmpty() ){
			right = stack.pop();
			left = stack.pop();
			if( left == null && right == null ) continue;
			if( left == null || right == null || left.val != right.val ) return false;
			stack.push(left.left);
			stack.push(right.right);
			stack.push(left.right);
			stack.push(right.left);
		}
		return true;
	}
}
