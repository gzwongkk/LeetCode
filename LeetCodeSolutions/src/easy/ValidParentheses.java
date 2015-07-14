package easy;

import java.util.Stack;

public class ValidParentheses {

	/**
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
	 * determine if the input string is valid. The brackets must close in the correct
	 * order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	 **/
	public static void main(String[] args) {
		String input = "Check new String[1]{character} out(Should return true)";
		System.out.println(isValid(input));
	}

	/*
	 * Use stack to do pattern matching is like a more intuitive way of bottom up approach like Huffman decoding.
	 */
	public static boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		int size = s.length();
		for( int i = 0; i < size; ++i ){
			switch(s.charAt(i)){
				case '(':case '{':case '[':
					stack.push(s.charAt(i));
					break;
				case ')':
					if(!stack.isEmpty() && stack.peek() == '(')
						stack.pop();
					else
						return false;
					break;
				case '}':
					if(!stack.isEmpty() && stack.peek() == '{')
						stack.pop();
					else
						return false;
					break;
				case ']':
					if(!stack.isEmpty() && stack.peek() == '[')
						stack.pop();
					else
						return false;
					break;
			}
		}
		return stack.isEmpty();
	}
}
