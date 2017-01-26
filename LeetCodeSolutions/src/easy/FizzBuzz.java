package easy;
import java.util.*;

public class FizzBuzz {
	/**
	 * Write a program that outputs the string representation of numbers from 1 to n.
	 * But for multiples of three it should output ¡§Fizz¡¨ instead of the number and for the multiples of five output ¡§Buzz¡¨. 
	 * For numbers which are multiples of both three and five output ¡§FizzBuzz¡¨.
	 **/
	public static void main(String[] args) {
		for ( String s : fizzBuzz(15) )
			System.out.println(s);
	}

	/*
	 * Trivial. Avoid using modulus as overhead grows with n.
	 */
	public static List<String> fizzBuzz(int n) {
		ArrayList<String> list = new ArrayList<>((n*3)>>1);
		for ( int i = 1, fizz = 1, buzz = 1; i <= n; ++i, ++fizz, ++buzz ) {
			if ( fizz == 3 && buzz == 5 ) {
				fizz = 0;
				buzz = 0;
				list.add("FizzBuzz");
			} else if ( fizz == 3 ) {
				fizz = 0;
				list.add("Fizz");
			} else if ( buzz == 5 ) {
				buzz = 0;
				list.add("Buzz");
			} else {
				list.add(""+i);
			}
		}
		return list;
	}
}
