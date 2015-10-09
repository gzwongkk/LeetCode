package easy;
import java.util.*;
import util.TreeNode;

public class BinaryTreePaths {
	/**
	 * Given a binary tree, return all root-to-leaf paths.
	 * For example, given the following binary tree:
	 *     1
		 /   \
		2     3
		 \
		  5
	 * All root-to-leaf paths are:
	 * ["1->2->5", "1->3"]
	 **/
	public static void main(String[] args) {
		System.out.println(binaryTreePaths(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3))));
	}

	/*
	 * Tree Traversal is best using recursion unless the nodes are too much that causes stack overflow.
	 */
	public static List<String> binaryTreePaths(TreeNode root){
		ArrayList<String> paths = new ArrayList<>();
		if( root != null ) goPath(paths, "", root);
		return paths;
	}
	
	public static void goPath(List<String> paths, String path, TreeNode node){
		if( node.left == null && node.right == null ) paths.add(path+node.val);
		if( node.left != null ) goPath(paths, path+node.val+"->", node.left);
		if( node.right != null ) goPath(paths, path+node.val+"->", node.right);
	}
}
