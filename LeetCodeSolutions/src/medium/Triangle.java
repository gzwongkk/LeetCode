package medium;

import java.util.LinkedList;
import java.util.List;

public class Triangle {

	/**
	 * Given a triangle, find the minimum path sum from top to bottom. Each step you may
	 * move to adjacent numbers on the row below. For example, given the following triangle
	 * [
	 * 			[2],
	 * 		   [3,4],
	 * 		  [6,5,7],
	 * 		 [4,1,8,3]
	 * ]
	 * The minimum path sum from top to bottom is 11 ( i.e., 2 + 3 + 5 + 1 = 11 ).
	 * Note: Bonus point if you are able to do this using only O(n) extra space, where n 
	 * is the total number of rows in the triangle.
	 **/
	public static void main(String[] args) {
		List<List<Integer>> triangle = new LinkedList<List<Integer>>();
		for( int i = 0; i < 4; ++i )
			triangle.add(new LinkedList<Integer>());
		int[]   a1 = new int[]{2},
				a2 = new int[]{3,4},
				a3 = new int[]{6,5,7}, 
				a4 = new int[]{4,1,8,3};
		for( int i : a1 ) triangle.get(0).add(i);
		for( int i : a2 ) triangle.get(1).add(i);
		for( int i : a3 ) triangle.get(2).add(i);
		for( int i : a4 ) triangle.get(3).add(i);
		System.out.println(minimumTotal(triangle));
	}

	/*
	 * Since the path can only be somewhere in between a vertical line or a diagonal, 
	 */
	public static int minimumTotal(List<List<Integer>> triangle){
		int[] DP = new int[triangle.size()+1];
		for( int i = triangle.size()-1; i >= 0; --i ){
			List<Integer> row = triangle.get(i);
			for( int j = 0; j <= i; ++j )
				DP[j] = row.get(j) + Math.min(DP[j], DP[j+1]);
		}
		return DP[0];
	}
}
