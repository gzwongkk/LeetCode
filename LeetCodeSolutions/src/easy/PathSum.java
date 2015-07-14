package easy;

import java.util.HashSet;
import java.util.LinkedList;

import util.TreeNode;

public class PathSum {

	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
	 * such that adding up all the values along the path equals the given sum. 
	 * For example: Given the below binary tree and sum = 22.
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \      \
	        7    2      1
	 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	 **/
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(-2, new TreeNode(1, new TreeNode(-1), null), new TreeNode(3)), 
				new TreeNode(-3, new TreeNode(-2), null));
		int sum = 2;
		System.out.println(hasPathSum(root, sum));
		System.out.println(hasPathSumRecursive(root, sum));
		System.out.println(hasPathSumRecursiveCompact(root, sum));
	}

	/*
	 * Depth First Search should be used to get the path sum from root to leaf.
	 * It can be done iteratively and recursively.
	 */
	public static boolean hasPathSum(TreeNode root, int sum){
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		int path = 0;
		if( root != null ) stack.push(root);
		while( !stack.isEmpty() ){
			TreeNode top = stack.peek();
			if( !visited.contains(top) ){
				path += top.val;
				visited.add(top);
				if( top.left  == null && top.right == null && path == sum ) return true;
				if( top.left  != null && !visited.contains(top.left ) ) stack.push(top.left);
				if( top.right != null && !visited.contains(top.right) ) stack.push(top.right);
			} else {
				path -= top.val;
				stack.pop();
			}
		}
		return false;
	}
	
	public static boolean hasPathSumRecursive(TreeNode root, int sum){
		if( root == null ) return false;
		if( root.left == null && root.right == null ) return sum == root.val;
		return hasPathSumRecursive(root.left, sum-root.val) || hasPathSumRecursive(root.right, sum-root.val);
	}
	
	public static boolean hasPathSumRecursiveCompact(TreeNode root, int sum){
		return root!=null && 
				((root.left == null && root.right == null && sum == root.val) 
						|| hasPathSumRecursiveCompact(root.left, sum-root.val) 
						|| hasPathSumRecursiveCompact(root.right, sum-root.val));
	}
}
