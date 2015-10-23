package medium;
import java.util.*;
import util.TreeNode;

public class BinaryTreePreorderTraversal {
	/**
	 * Given a binary tree, return the preorder traversal of its nodes' values.
	 **/
	public static void main(String[] args) {
		System.out.println(preorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
	}

	/*
	 * Preorder traversal is to visit root, then left, then right.
	 */
	public static List<Integer> preorderTraversal(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while( !stack.isEmpty() || root != null ){
			if( root != null ){
				ans.add(root.val);
				if( root.right != null )
					stack.push(root.right);
				root = root.left;
			} else {
				root = stack.pop();
			}
		}
		return ans;
	}
}
