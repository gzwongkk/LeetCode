package easy;

public class ExcelSheetColumnNumber {

	/**
	 * Given a column title as appear in an Excel sheet, return its corresponding column number.
	 **/
	public static void main(String[] args) {
		String input = "AZ";
		System.out.println(titleToNumber(input));
	}

	/*
	 * Build up the solution with basic understanding of char is fine.
	 */
	public static int titleToNumber(String s){
		int size = s.length(), ans = 0;
		for( int i = 0; i < size; ++i )
			ans = ans * 26 + s.charAt(i) - 64;
		return ans;
	}

	public static int titleToNumberCompact(String s){
		return s.length() == 0?0:(s.charAt(s.length()-1)-64)+26*titleToNumberCompact(s.substring(0, s.length()-1));
	}
}
