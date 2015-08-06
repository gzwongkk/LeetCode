package medium;

import java.util.HashMap;

public class FractionToRecurringDecimal {

	/**
	 * Given two integers representing the numerator and denominator of a fraction, return the
	 * fraction in string format. If the fractional part is repeating, enclose the repeating part
	 * in parentheses. For example,
	 * Given numerator = 1, denominator = 2, return "0.5"
	 * Given numerator = 2, denominator = 1, return "2"
	 * given numerator = 2, denominator = 3, return "0.(6)"
	 **/
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(1, 2));
		System.out.println(fractionToDecimal(2, 1));
		System.out.println(fractionToDecimal(2, 3));
		System.out.println(fractionToDecimal(-50, 8));
		System.out.println(fractionToDecimal(7, -12));
		System.out.println(fractionToDecimal(-1, Integer.MIN_VALUE));
	}

	/*
	 * The edge cases are so nasty. It is fun to figure out how we do long division, 
	 * but not handling those nasty stupid boundary problems.
	 */
	public static String fractionToDecimal(int numerator, int denominator){
		if( numerator == 0 ) return "0";
		StringBuilder decimal = new StringBuilder();
		if( numerator < 0 ^ denominator < 0 ) decimal.append('-');
		long num = Math.abs((long) numerator), den = Math.abs((long) denominator);
		decimal.append(num / den);
		num = num % den * 10;
		if( num != 0 ) decimal.append('.');
		int index = decimal.length();
		HashMap<Long, Integer> occured = new HashMap<Long, Integer>();
		
		while( num != 0 ){
			if( occured.containsKey(num) ){
				decimal.insert(occured.get(num), "(");
				decimal.append(')');
				break;
			} else {
				occured.put(num, index);
				decimal.append(num / den);
				num = num % den * 10;
				++index;
			}
		}
		return decimal.toString();
	}
}
