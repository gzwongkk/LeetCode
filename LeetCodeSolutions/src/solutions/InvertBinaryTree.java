package solutions;

import java.util.LinkedList;

public class InvertBinaryTree {
	/*
	 * Invert a binary tree.
			 4
		   /   \
		  2     7
		 / \   / \
		1   3 6   9
		
	 * to

		     4
		   /   \
		  7     2
		 / \   / \
		9   6 3   1
	 * Trivia:
	 * This problem was inspired by this original tweet by Max Howell:
	 * 	Google: 90% of our engineers use the software you wrote (homebrew), but you
	 * can't invert a binary tree on a whiteboard so fuck off.
	 */

	public static void main(String[] args) {
		InvertBinaryTree solution = new InvertBinaryTree();
		TreeNode n4 = solution.new TreeNode(1);
		TreeNode n5 = solution.new TreeNode(3);
		TreeNode n6 = solution.new TreeNode(6);
		TreeNode n7 = solution.new TreeNode(9);
		TreeNode n2 = solution.new TreeNode(2,n4,n5);
		TreeNode n3 = solution.new TreeNode(7,n6,n7);
		TreeNode n1 = solution.new TreeNode(4,n2,n3);
		System.out.println(n1);
		solution.invertTree(n1);
		System.out.println(n1);
	}
	
	public TreeNode invertTree(TreeNode root){
		if(root == null) return null;
		TreeNode temp = root.left;
		root.left = (root.right == null)?null:invertTree(root.right);
		root.right = (temp == null)?null:invertTree(temp);
		return root;
	}

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(int x, TreeNode l, TreeNode r){
			val = x;
			left = l;
			right = r;
		}
		@Override
		public String toString(){
			LinkedList<TreeNode> root = new LinkedList<TreeNode>();
			LinkedList<TreeNode> leaf = new LinkedList<TreeNode>();
			root.add(this);
			String output = "";
			while( !root.isEmpty() ){
				for( TreeNode t : root ){
					if( t.left != null )
						leaf.add(t.left);
					if( t.right != null )
						leaf.add(t.right);
					output += t.val + " ";
				}
				root.clear();
				LinkedList<TreeNode> temp = leaf;
				leaf = root;
				root = temp;
				output += '\n';
			}
			return output;
		}
	}
}
