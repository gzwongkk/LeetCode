package easy;

import java.util.LinkedList;
import util.TreeNode;

public class MaximumDepthOfBinaryTree {

	/**
	 * Given a binary tree, find its maximum depth.
	 * The maximum depth is the number of nodes along the longest path from the root node
	 * down to the farthest leaf node.
	 **/
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
		System.out.println(maxDepth(root));
	}

	/*
	 * Breadth first search works well since the problem must be solved with traveling all
	 * nodes, in O(n) time. Depth first search can also solve this, but the advantage of 
	 * DFS over BFS is not convincing enough to apply that strategy. 
	 * Plus DFS requires coloring, while BFS in binary tree does not need to worry about back edge.
	 */
	public static int maxDepth(TreeNode root){
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		if( root != null ) queue.add(root);
		int count = 0;
		while( !queue.isEmpty() ){
			++count;
			for( int i = queue.size(); i > 0 ; --i ){
				if( queue.peek().left  != null ) queue.add(queue.peek().left);
				if( queue.peek().right != null ) queue.add(queue.peek().right);
				queue.poll();
			}
		}
		return count;
	}
}
