package easy;

import java.util.Stack;

import util.TreeNode;

public class SumLeftLeaves {
	/**
	 * Find the sum of all left leaves in a given binary tree.
	 **/
	public static void main(String[] args) {
		System.out.println(sumOfLeftLeaves(new TreeNode(3, 
				new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
		System.out.println(sumOfLeftLeavesRecursiveLocal(new TreeNode(3, 
				new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
		System.out.println(sumOfLeftLeavesRecursiveGlobal(new TreeNode(3, 
				new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
	}
	
	// Traverse Binary Tree in iterative and recursive methods.
	public static int sumOfLeftLeaves(TreeNode root) {
		if ( root == null ) return 0;
		int sum = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while ( !stack.isEmpty() ) {
			TreeNode node = stack.pop();
			if ( node.left != null ) {
				if ( node.left.left == null && node.left.right == null ) {
					sum += node.left.val;
				} else {
					stack.push(node.left);
				}
			}
			if ( node.right != null ) stack.push(node.right);
		}
		
		return sum;
	}

	public static int sumOfLeftLeavesRecursiveLocal(TreeNode root) {
		if ( root == null ) return 0;
		int sum = 0;
		if ( root.left != null ) {
			if ( root.left.left == null && root.left.right == null )
				sum += root.left.val;
			else
				sum += sumOfLeftLeavesRecursiveLocal(root.left);
		}
		return sum+sumOfLeftLeavesRecursiveLocal(root.right);
	}
	
	public static TreeNode parentLeft;
	public static int sumOfLeftLeavesRecursiveGlobal(TreeNode root) {
		if ( root == null ) return 0;
		if ( root.left == null && root.right == null && root == parentLeft ) 
			return root.val + sumOfLeftLeavesRecursiveGlobal(root.right);
		parentLeft = root.left;
		return sumOfLeftLeavesRecursiveGlobal(root.left)+sumOfLeftLeavesRecursiveGlobal(root.right);
	}
}
