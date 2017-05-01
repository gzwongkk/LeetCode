package easy;

import java.util.HashMap;

import util.TreeNode;

public class PathSumToValue {
	/**
	 * You are given a binary tree in which each node contains an integer value.
	 * 
	 * Find the number of paths that sum to a given value.
	 * 
	 * The path does not need to start or end at the root or a leaf, but it must go downwards 
	 * (traveling only from parent nodes to child nodes).
	 * 
	 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
	 **/
	public static void main(String[] args) {
		System.out.println(pathSum(new TreeNode(new Integer[]{10,-5,null, 5,null}),10));
		System.out.println(pathSum(new TreeNode(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1}),8));
	}

	/*
	 * Great solution from tankztc. Use Hashmap to prevent duplicated scan.
	 */
	public static int pathSum(TreeNode root, int sum){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		return pathSumHash(root, sum, 0, map);
	}
	
	public static int pathSumHash(TreeNode root, int sum, int cur, HashMap<Integer, Integer> map){
		if ( root == null ) return 0;
		// the sum from root to this node
		cur += root.val;
		
		// suppose there is a sub-path from root to current node that has the target length
		// Then Total sum from root = target + the remaining paths
		// We want the number of remaining paths = total sum - target
		int ans = map.getOrDefault(cur - sum, 0);
		
		// put the path sum till now into the map
		map.put(cur, map.getOrDefault(cur, 0)+1);
		// recursively check children
		ans += pathSumHash(root.left, sum, cur, map) + pathSumHash(root.right, sum, cur, map);
		// remove the path sum after traversal
		map.put(cur, map.get(cur)-1);	// computeIfPresent is extremely slow, don't use
		
		return ans;
	}
	
	// DFS
	public static int pathSumDFS(TreeNode root, int sum) {
		if( root == null ) return 0;
		return pathSumNew(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}
	
	public static int pathSumNew(TreeNode root, int sum) {
		if( root == null ) return 0;
		return pathSumNew(root.left, sum-root.val) + pathSumNew(root.right, sum-root.val) + (sum==root.val?1:0);
	}
}
