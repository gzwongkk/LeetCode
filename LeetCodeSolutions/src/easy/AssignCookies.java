package easy;

import java.util.Arrays;

public class AssignCookies {
	/**
	 * Assume you are an awesome parent and want to give your children some cookies. But, you should give 
	 * each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a 
	 * cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can 
	 * assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the 
	 * number of your content children and output the maximum number.
	 * 
	 * Note:
	 * You may assume the greed factor is always positive. 
	 * You cannot assign more than one cookie to one child.
	 * 
	 **/
	public static void main(String[] args) {
		System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
		System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
	}
	
	// two pointer and sorting O(n log n)
	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int num = 0;
		for ( int i = 0; i < s.length && num < g.length; ++i ){
			if ( s[i] >= g[num] ) ++num;
		}
		return num;
	}
}
