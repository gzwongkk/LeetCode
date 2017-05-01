package easy;

public class NumberOfSegmentsInAString {
	/**
	 * Count the number of segments in a string, where a segment is defined to be a 
	 * contiguous sequence of non-space characters.
	 * 
	 * Please note that the string does not contain any non-printable characters.
	 **/
	public static void main(String[] args) {
		System.out.println(countSegments("Hello, my name is John"));
	}

	public static int countSegments(String s) {
		return trivial(s);
	}
	
	/*
	 * 1. for loops ~2ms
	 * 2. RegEx ~5ms
	 */
	public static int trivial(String s) {
		int ans = 0;
		char[] c = s.toCharArray();
		for ( int i = 0; i < c.length; ++i ) {
			if ( c[i] != ' ' && ( i == 0 || c[i-1] == ' ' ) ) ++ans;
		}
		return ans;
	}
	
	public static int regEx(String s) {
		return ("1 " + s).split(" +").length - 1;
	}
}
