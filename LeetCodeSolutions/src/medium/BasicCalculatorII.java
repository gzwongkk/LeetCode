package medium;

import java.util.Stack;

public class BasicCalculatorII {

	/**
	 * Implement a basic calculator to evaluate a simple expression string.
	 * The expression string contains only non-negative integers, +, -, *, / operators
	 * and empty spaces. The integer division should truncate toward zero. You may assume
	 * that the given expression is always valid. Some examples:
	 * "3+2*2" = 7
	 * " 3/2 " = 1
	 * " 3+5 / 2 " = 5
	 **/
	public static void main(String[] args) {
		System.out.println(calculate("3+2*2"));
		System.out.println(calculate(" 3/2 "));
		System.out.println(calculate(" 3+5 / 2 "));
		System.out.println(calculate("1-1+1"));
		System.out.println(calculateSign("3+2*2"));
		System.out.println(calculateSign(" 3/2 "));
		System.out.println(calculateSign(" 3+5 / 2 "));
		System.out.println(calculateSign("1-1+1"));
	}

	/*
	 * Shunting-yard algorithm always work for parsing infix expression.
	 * But still, for a problem which precedence relationship is not complicated, there
	 * is a sign-based solution who runs like Hong Kong journalists. Almost 50% faster.
	 */
	public static int calculate(String s){
		Stack<Integer> operands = new Stack<Integer>();
		Stack<Character> operators = new Stack<Character>();
		operands.push(0);
		for( char c : s.toCharArray() ){
			if( c == ' ' ){ continue;
			} else if( c == '*' || c == '/' ){
				if( !operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')) {
					int b = operands.pop();
					operands.push( operators.pop() == '*'? operands.pop()*b: operands.pop()/b );
				}
				operators.push(c);
				operands.push(0);
			} else if ( c == '+' || c == '-' ){
				while( !operators.isEmpty() ) {
					int b = operands.pop();
					switch( operators.pop() ){
					case '*':operands.push(operands.pop() * b);	break;
					case '/':operands.push(operands.pop() / b);	break;
					case '+':operands.push(operands.pop() + b); break;
					case '-':operands.push(operands.pop() - b); break;
					}
				}
				operators.push(c);
				operands.push(0);
			} else operands.push(operands.pop()*10+c-'0');
		}

		while( !operators.isEmpty() ){
			int b = operands.pop();
			switch( operators.pop() ){
			case '*':operands.push(operands.pop() * b);	break;
			case '/':operands.push(operands.pop() / b);	break;
			case '+':operands.push(operands.pop() + b); break;
			case '-':operands.push(operands.pop() - b); break;
			}
		}
		return operands.pop();
	}

	public static int calculateSign(String s){
		Stack<Integer> operands = new Stack<Integer>();
		int number = 0;
		char sign = '+';
		char[] exp = s.toCharArray();
		for( int i = 0; i < exp.length; ++i ){
			if( Character.isDigit(exp[i]) ) number = number * 10 + exp[i] - '0';
			if( exp[i] == '+' || exp[i] == '-' || exp[i] == '*' || exp[i] == '/' || i == exp.length - 1){
				switch( sign ){
				case '*':operands.push(operands.pop() * number); break;
				case '/':operands.push(operands.pop() / number); break;
				case '+':operands.push(number); break;
				case '-':operands.push(-number); break;
				}
				sign = exp[i];
				number = 0;
			}
		}
		for( int operand : operands )
			number += operand;
		return number;
	}
}
