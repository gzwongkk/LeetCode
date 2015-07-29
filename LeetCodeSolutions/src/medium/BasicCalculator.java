package medium;

import java.util.Stack;

public class BasicCalculator {

	/**
	 * Implement a basic calculator to evaluate a simple expression string. The expression string
	 * may contain open ( and closing parentheses ), the plus + or minus sing -, non-negative 
	 * integers and empty spaces. You may assume that the given expression is always valid.
	 * Some examples:
	 * "1 + 1" = 2
	 * " 2-1 + 2 " = 3
	 * "(1+(4+5+2)-3)+(6+8)" = 23
	 * Note: Do not use the "eval" built-in library function.
	 **/
	public static void main(String[] args) {
		System.out.println(calculate("1 + 1"));
		System.out.println(calculate(" 2-1 + 2 "));
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}

	/*
	 * The standard in-fix calculation methods still works for this problem, but there is a better
	 * solution which utilizes the fact the parenthesis only changes the sign of operands. Less 
	 * stack operations are required as the number can be calculated on the fly, most of the time.
	 */
	public static int calculate(String s){
		Stack<Integer> operand = new Stack<Integer>();
		Stack<Character> operator = new Stack<Character>();
		operand.push(0);
		for( char c : s.toCharArray() ){
			switch(c){
			case ' ': break;
			case '+': case '-':
				if( !operator.isEmpty() && operator.peek() != '(' ){
					int a = operand.pop();
					operand.push( operator.pop() == '+'? operand.pop()+a : operand.pop()-a );
				}
				operand.push(0);
			case '(': 
				operator.push(c);
				break;
			case ')':
				while( operator.peek() != '(' ){
					int b = operand.pop(), a = operand.pop();
					char o = operator.pop();
					operand.push( o == '+'? a+b : a-b );
				}
				operator.pop();
				break;
			default:
				operand.push(operand.pop()*10+c-'0');
			}
		}
		while( !operator.isEmpty() ){
			int a = operand.pop();
			operand.push( operator.pop() == '+'? operand.pop()+a : operand.pop()-a );
		}
		return operand.pop();
	}
	
	public static int calculateSign(String s){
		Stack<Integer> stack = new Stack<Integer>();
		int ans = 0, number = 0, sign = 1;
		for( char c : s.toCharArray() ){
			switch(c){ 
			case ' ': break;
			case '+': case '-':
				ans += sign * number;
				number = 0;
				sign = c == '+'? 1: -1;
				break;
			case '(':
				stack.push(ans);
				stack.push(sign);
				ans = 0; sign = 1;
				break;
			case ')':
				ans = (ans + sign * number) * stack.pop() + stack.pop();
				number = 0;
				break;
			default:
				number = 10 * number + c - '0';
			}
		}
		if( number != 0 ) ans += sign * number;
		return ans;
	}
}
