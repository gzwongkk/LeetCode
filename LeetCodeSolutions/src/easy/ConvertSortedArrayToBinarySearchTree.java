package easy;

import util.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
	/**
	 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
	 **/
	public static void main(String[] args) {
		
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		if ( nums.length == 0 ) return null;
		return insertNodes(nums, 0, nums.length-1);
	}
	
	public static TreeNode insertNodes(int[] nums, int left, int right) {
		if ( left > right ) return null;
		int k = (left+right)/2;
		TreeNode node = new TreeNode(nums[k]);
		node.left = insertNodes(nums, left, k-1);
		node.right = insertNodes(nums, k+1, right);
		return node;
	}
}
