package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {

	/**
	 * The gray code is a binary numeral system where two successive values differ in only one bit.
	 * Given a non-negative integer n representing the total number of bits in the code, print the
	 * sequence of gray code. A gray code sequence must begin with 0.
	 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	 * 00 - 0
	 * 01 - 1
	 * 11 - 3
	 * 10 - 2
	 * Note: For a given n, a gray code sequence is not uniquely defined.
	 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
	 * For now, the judge is able to judge based on one instance of gray code sequence.
	 **/
	public static void main(String[] args) {
		System.out.println(grayCode(5));
		System.out.println(grayCodeBit(5));
	}

	/*
	 * Gray code is a typical recursive method. Padding 0 in front of gray code (n-1), and pad 1 in
	 * front of its reverse order. The bitwise operations used here is quite interesting.
	 */
	public static List<Integer> grayCode(int n){
		ArrayList<Integer> gray = new ArrayList<Integer>( 1 << n );
		gray.add(0);
		int power = 1;
		for( int i = 0; i < n; ++i, power <<= 1 )
			for( int j = power-1; j >= 0 ; --j )
				gray.add(gray.get(j)|power);
		return gray;
	}
	
	public static List<Integer> grayCodeBit(int n){
		List<Integer> gray = new LinkedList<Integer>();
		for( int i = 0; i < 1 << n; ++i ) gray.add( i ^ i>>1 );
		return gray;
	}
}
