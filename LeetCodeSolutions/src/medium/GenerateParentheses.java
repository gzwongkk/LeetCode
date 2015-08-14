package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

	/**
	 * Given n pairs of parentheses, write a function to generate all combinations of
	 * well-formed parentheses. For example, given n = 3, a solution set is:
	 * "((()))", "(()())", "(())()", "()(())", "()()()" 
	 **/
	public static void main(String[] args) {
		System.out.println(generateParenthesis(6));
	}

	/*
	 * At first I think this is a variation of AVL tree, since I discover that the number of
	 * elements in the solution set looks a lot like it. But then it is much complicated than
	 * that. It requires all previous nodes to generate new list. DP does best in this situation.
	 * Another solution traverse the whole binary tree of all possible combination. it takes
	 * longer as it will have to check if the new combination is valid.
	 */
	public static List<String> generateParenthesis(int n){
		List<List<String>> ans = new ArrayList<List<String>>(n+1);
		ans.add(Arrays.asList(""));
		for( int i = 1; i <= n; ++i ){
			ArrayList<String> level = new ArrayList<String>();
			for( int j = 0; j < i; ++j )
				for( String left : ans.get(j) )
					for( String right : ans.get( i-j-1 ) )
						level.add("("+left+")"+right);
			ans.add(level);
		}
		return ans.get(n);
	}
	
	public static List<String> generateParenthesisTraversal(int n){
		List<String> ans = new ArrayList<String>();
		Stack<String> str = new Stack<String>();
		Stack<Integer> val = new Stack<Integer>();
		str.push("(");
		val.push(0);
		while( !str.isEmpty() ){
			String s = str.pop();
			int v    = val.pop();
			if( s.length() == n << 1 ){
				ans.add(s);
				continue;
			}
			if( s.length() - v < n ){
				str.push(s+'(');
				val.push(v);
			}
			if( v << 1 < s.length() ){
				str.push(s+')');
				val.push(v+1);
			}
		}
		return ans;
	}
	
	public static List<String> generateParenthesisRecursive(int n){
		List<String> ans = new ArrayList<String>();
		recursiveHelper(ans, n, "(", 1, 0);
		return ans;
	}
	
	public static void recursiveHelper(List<String> ans, int n, String str, int num, int val){
		if( num == n << 1 ) ans.add(str);
		if( num - val < n ) recursiveHelper(ans, n, str+'(', num+1, val);
		if( val<<1 < num  ) recursiveHelper(ans, n, str+')', num+1, val+1);
	}
}
