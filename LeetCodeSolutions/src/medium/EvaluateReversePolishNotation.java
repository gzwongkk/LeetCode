package medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	/**
	 * Evaluate the value of an arithmetic expression in Reverse polish Notation (Prefix).
	 * Valid operators are +,-,*,/. Each operand may be an integer or another expression.
	 * Some examples:
	 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 **/
	public static void main(String[] args) {
		System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
		System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
		System.out.println(evalRPNErrorHandling(new String[]{"2", "1", "+", "3", "*"}));
		System.out.println(evalRPNErrorHandling(new String[]{"4", "13", "5", "/", "+"}));
	}

	/*
	 * Two stacks are not required because it is prefix expression already.
	 * The second solution is a fun way to think, utilizing the try/catch mechanism.
	 * 	Note that it is much much slower than the first one.
	 */
	public static int evalRPN(String[] tokens){
		Stack<Integer> operands = new Stack<Integer>();
		int temp;
		for( String token : tokens ){
			if( token.equals("+") )	operands.push(operands.pop()+operands.pop());
			else if ( token.equals("*") ) operands.push(operands.pop()*operands.pop());
			else if ( token.equals("-") ){
				temp = operands.pop();
				operands.push(operands.pop()-temp);
			} else if ( token.equals("/") ){
				temp = operands.pop();
				operands.push(operands.pop()/temp);
			} else operands.push(Integer.valueOf(token));
		}
		return operands.pop();
	}
	
	public static int evalRPNErrorHandling(String[] tokens){
		Stack<Integer> operands = new Stack<Integer>();
		for( String token : tokens ){
			try {
				operands.push(Integer.valueOf(token));
			} catch (NumberFormatException e){
				int b = operands.pop(), a = operands.pop();
				if( token.equals("+") )	operands.push(a+b);
				else if ( token.equals("*") ) operands.push(a*b);
				else if ( token.equals("-") ) operands.push(a-b);
				else operands.push(a/b);
			}
		}
		return operands.pop();
	}
}
