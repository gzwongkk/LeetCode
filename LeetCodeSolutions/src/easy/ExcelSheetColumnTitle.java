package easy;

import java.util.Stack;

public class ExcelSheetColumnTitle {

	/**
	 * Given a positive integer, return its corresponding column title as
	 * appear in an Excel sheet.
	 **/
	public static void main(String[] args) {
		int input = 52;
		System.out.println(convertToTitle(input));
	}

	/*
	 * Break down into String using the characteristics of char.
	 */
	public static String convertToTitle(int n){
		Stack<Character> stack = new Stack<Character>();
		while( n > 0 ){
			stack.push((char)(--n%26+65));
			n /= 26;
		}
		String ans = "";
		while( !stack.isEmpty() )
			ans += stack.pop();
		return ans;
	}

	public static String convertToTitleRecursive(int n){
		return n == 0 ? "": convertToTitle(--n/26) + (char)(65+(n%26));
	}
}
