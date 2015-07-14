package easy;

import java.util.HashMap;
import java.util.LinkedList;
import util.TreeNode;

public class BalancedBinaryTree {

	/**
	 * Given a binary tree, determine if it is height-balanced.
	 * For this problem, a height-balanced binary tree is defined as a binary tree in which the
	 * depth of the two subtrees of every node never differ by more than 1.
	 **/
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3,new TreeNode(9), new TreeNode(20, new TreeNode(15, new TreeNode(8), null), new TreeNode(7)));
		System.out.println(root.toString());
		System.out.println(isBalancedDFS(root));
	}

	/*
	 * DFS should be used in this problem because of its recursive nature which gives easy implementation.
	 * 1) O(n log n) time recursion, simple implementation of different cases
	 * 2) O(n) time as it must traverse the nodes once and only once.
	 * 3) O(n) time O(n) space, non recursive implementation of 2, with possibility of early termination.
	 */
	public static boolean isBalanced(TreeNode root){
		if( root == null ) return true;
		return Math.abs(isBalancedDepth(root.left)-isBalancedDepth(root.right)) <= 1
				&& isBalanced(root.left) && isBalanced(root.right);
	}

	public static int isBalancedDepth(TreeNode root){
		if( root == null ) return 0;
		return Math.max(isBalancedDepth(root.left), isBalancedDepth(root.right))+1;
	}
	
	public static boolean isBalancedBottomUp(TreeNode root){
		return height(root) != 1;
	}
	
	public static int height(TreeNode root){
		if( root == null ) return 0;
		int left  = height(root.left);
		if( left == -1 ) return -1;
		int right = height(root.right);
		if( right == -1) return -1;
		
		if( Math.abs(left-right) > 1 ) return -1;
		return Math.max(left, right) + 1;
	}
	
	public static boolean isBalancedDFS(TreeNode root){
		HashMap<TreeNode, Integer> visited = new HashMap<TreeNode, Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		int path = 0;
		if( root != null ) stack.push(root);
		while( !stack.isEmpty() ){
			TreeNode top = stack.peek();
			if( !visited.containsKey(top) ){
				visited.put(top, ++path);
				if( top.right != null && !visited.containsKey(top.right) ) stack.push(top.right);
				if( top.left  != null && !visited.containsKey(top.left ) ) stack.push(top.left);
			} else {
				int leftLevel  = top.left  == null? path: visited.get(top.left);
				int rightLevel = top.right == null? path: visited.get(top.right);
				if( Math.abs(leftLevel-rightLevel) > 1 ) return false;
				else visited.put(top, Math.max(leftLevel, rightLevel));
				--path;
				stack.pop();
			}
		}
		return true;
	}
}
