package easy;

import java.util.HashSet;

public class HappyNumber {
	
	/**
	 * Write an algorithm to determine if a number is "happy".
	 * A happy number is a number defined by the following process: Starting with any positive
	 * integer, replace the number by the sum of the squares of its digits, and repeat the process
	 * until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does
	 * not include 1. Those numbers for which this process ends in 1 are happy numbers.
	 * Example: 19 is a happy number
	 * 	1^2 + 9^2 = 82
	 * 	8^2 + 2^2 = 68
	 *  6^2 + 8^2 = 100
	 *  1^2 + 0^2 + 0^2 = 1
	 */
	public static void main(String[] args){
		int input = 19;
		System.out.println(isHappy(input));
	}
	
	/*
	 * 1) O(n) space: uses HashSet to determine existence of recurring number.
	 * 2) O(1) space: cycle detection in linked list. Make two pointers which first do one at a time
	 * 			and the second twice at a time. If recurring number exists, they will be eventually equal.
	 * Note that recurring number includes 1.
	 */
	public static boolean isHappy(int n){
		HashSet<Integer> table = new HashSet<Integer>();
		while(true){
			int num = calculation(n);
			if( num == 1 )
				return true;
			else if( table.contains(num) )
				return false;
			table.add(num);
			n = num;
		}
	}
	
	public static boolean isHappyCycle(int n){
		int first = n, second = n;
		do{
			first = calculation(first);
			second = calculation(second);
			second = calculation(second);
		} while(first != second);
		return first == 1;
	}
	
	public static int calculation(int n){
		int ans = 0;
		for(; n > 0 ; n/=10 )
			ans += Math.pow(n%10,2);
		return ans;
	}
}
