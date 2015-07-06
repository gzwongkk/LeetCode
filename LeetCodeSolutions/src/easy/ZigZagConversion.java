package easy;

public class ZigZagConversion {

	/*
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
	 * of rows like this:(you may want to display this pattern in a fixed font for better legibility)
	 * 	P   A   H   N
	 *	A P L S I I G
	 *	Y   I   R
	 * and then read line by line: "PAHNAPLSIIGYIR"
	 * Write the code that will take a string and make this conversion given a number of rows:
	 * string convert(string text, int nRows);
	 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	 */
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		System.out.println(convert(s, 3));
	}

	/*
	 * The key of solution is to come out with the cycle of numRows.
	 * This is an O(n) time O(1) space solution. One can make O(n) space to speed up,
	 * by turning input into char array for O(1) retrieval time or make a full copy of the
	 * concatenated string for future efficiency.
	 */
	public static String convert(String s, int numRows){
		if( s == null ) return null;
		else if( numRows == 1 ) return s;
		String ans = "";
		int size = s.length(), cycle = 2*numRows-2;
		for( int i = 0; i < size; i += cycle)
			ans += s.charAt(i);
		for( int i = 1; i < numRows-1; ++i){
			for( int j = i; j < size; j += cycle){
				ans += s.charAt(j);
				if( j+cycle-2*i < size ) ans += s.charAt(j+cycle-2*i);
			}
		}
		for( int i = numRows-1; i < size; i += cycle)
			ans += s.charAt(i);
		return ans;
	}
}
