package easy;

public class LongestCommonPrefix {

	/**
	 * Write a function to find the longest common prefix string amongst an array of strings.
	 */
	public static void main(String[] args) {
		String[] input = new String[]{"Testing", "Testing One", "Testing Two", "Test...wait what?"};
		System.out.println(longestCommonPrefix(input));
	}

	/*
	 * 1) Build up the solution by matching the characters "vertically".
	 * 2) Narrow the solution by starting with first string, and discard the unmatched characters,
	 * 			in which it is similar to a "horizontal" matching. But this is not good as the actual
	 * 			work done might be huge as in this example 
	 * 			{"This example is long long long","That example is long long long"}.
	 */
	public static String longestCommonPrefix(String[] strs){
		if( strs == null || strs.length == 0 ) return "";
		for( int s = 0; s < strs[0].length(); ++s){
			char c = strs[0].charAt(s);
			for( int i = 1; i < strs.length; ++i )
				if( s >= strs[i].length() || c != strs[i].charAt(s) )
					return strs[0].substring(0, s);
		}
		return strs[0];
	}
}
