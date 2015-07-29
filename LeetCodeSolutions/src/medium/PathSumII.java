package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class PathSumII {

	/**
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum 
	 * equals the given sum. For example: Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	 * return [[5,4,11,2],[5,8,4,5]]
	 **/
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
				new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
		System.out.println(pathSum(root, 22));
		System.out.println(pathSumDFS(root, 22));
	}

	/*
	 * The challenging part for this problem is to separate left child and right child.
	 * This time iterative solution runs much slower than recursive, because of the existence of visited.
	 * Since the problem restrict the graph to be a binary tree, DFS will never check a visited node. 
	 */
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		LinkedList<Integer> set = new LinkedList<Integer>();
		int path = 0;
		if( root != null ) stack.push(root);
		while( !stack.isEmpty() ){
			TreeNode top = stack.peek();
			if( !visited.contains(top) ){
				path += top.val;
				visited.add(top);
				set.add(top.val);
				if( top.left == null && top.right == null && path == sum )
					ans.add(new LinkedList<Integer>(set));
				else if( top.left  != null && !visited.contains(top.left)  ) stack.push(top.left);
				else if( top.right != null && !visited.contains(top.right) ) stack.push(top.right);
			} else {
				if( top.right != null && !visited.contains(top.right) ) stack.push(top.right);
				else {
					path -= stack.pop().val;
					set.removeLast();
				}
			}
		}
		return ans;
    }
	
	public static List<List<Integer>> pathSumDFS(TreeNode root, int sum){
		List<List<Integer>> ans = new LinkedList<List<Integer>>();
		LinkedList<Integer> set = new LinkedList<Integer>();
		pathSumDFS(root, sum, ans, set);
		return ans;
	}

	public static void pathSumDFS(TreeNode root, int sum, List<List<Integer>> ans, LinkedList<Integer> set){
		if( root == null ) return;
		set.add(root.val);
		if( root.left == null && root.right == null && root.val == sum )
			ans.add( new LinkedList<Integer>(set) );
		else{
			pathSumDFS(root.left , sum-root.val, ans, set);
			pathSumDFS(root.right, sum-root.val, ans, set);
		}
		set.removeLast();
	}
}
