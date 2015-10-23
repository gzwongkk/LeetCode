package medium;
import java.util.*;

import util.TreeNode;

public class BinaryTreeInorderTraversal {
	/**
	 * Given a binary tree, return the inorder traversal of its nodes' values.
	 **/
	public static void main(String[] args) {
		System.out.println(inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
	}


	/*
	 * Inorder traversal is to visit left, then root, then right.
	 */
	public static List<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while( !stack.isEmpty() || root != null ){
			if( root != null ){
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				ans.add(root.val);
				root = root.right;
			}
		}
		return ans;
	}
}
