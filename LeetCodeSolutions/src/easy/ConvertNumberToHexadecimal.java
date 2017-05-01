package easy;

public class ConvertNumberToHexadecimal {
	/**
	 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, 
	 * two’s complement method is used.
	 * 
	 * Note:
	 * All letters in hexadecimal (a-f) must be in lowercase.
	 * 
	 * The hexadecimal string must not contain extra leading 0s. If the number is zero, 
	 * it is represented by a single zero character '0'; otherwise, the first character 
	 * in the hexadecimal string will not be the zero character.
	 * 
	 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
	 * 
	 * You must not use any method provided by the library which converts/formats the number to hex directly.
	 **/
	public static void main(String[] args) {
		System.out.println(toHex(26));
		System.out.println(toHex(-1));
	}

	public static char[] digits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	
	public static String toHex(int num) {
		if ( num == 0 ) return "0";
		StringBuilder n = new StringBuilder();
		
		while ( num != 0 ) {
			n.append(digits[num&15]);
			num >>>= 4;
		}
		
		return n.reverse().toString();
	}
}
