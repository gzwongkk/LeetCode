package easy;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

public class ModeinBinarySearchTree {
	/**
	 * Given a binary search tree (BST) with duplicates, find all the mode(s) 
	 * (the most frequently occurred element) in the given BST.
	 * 
	 * Assume a BST is defined as follows:
	 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
	 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
	 * Both the left and right subtrees must also be binary search trees.
	 **/
	public static void main(String[] args) {
		for ( int i : findMode(new TreeNode(new Integer[]{1,null,2})) )
			System.out.println(i);
	}

	public static int[] findMode(TreeNode root) {
		return findModeInorder(root); 
	}

	/*
	 * Inorder can handle a lot of traversal problems.
	 */
	public static int max = -1;
	public static int count = 0;
	public static Integer prev;
	public static int[] findModeInorder(TreeNode root) {
		if ( root == null ) return new int[0];
		
		List<Integer> list = new ArrayList<Integer>();
		prev = root.val;
		inorder(root, list);
		
		int[] ans = new int[list.size()];
		for ( int i = 0; i < ans.length; ++i ) 
			ans[i] = list.get(i);
		return ans;
	}
	
	public static void inorder(TreeNode root, List<Integer> list){
		if ( root == null ) return;
		inorder(root.left, list);
		count = root.val == prev? count+1: 1;
		
		if ( count == max ) {
			list.add(root.val);
		} else if ( count > max ) {
			max = count;
			list.clear();
			list.add(root.val);
		}
		
		prev = root.val;
		inorder(root.right, list);
	}
}
