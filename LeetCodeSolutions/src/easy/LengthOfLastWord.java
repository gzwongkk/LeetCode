package easy;

public class LengthOfLastWord {

	/**
	 * Given a string s consists of upper/lower-case alphabets and empty space
	 * characters ' ', return the length of last word in the string.
	 * if the last word does not exist, return 0.
	 * Note: A word is defined as a character sequence consists of non-space 
	 * characters only. For example, Given s = "Hello World", return 5.
	 **/
	public static void main(String[] args) {
		String input = "Hello World";
		System.out.println(lengthOfLastWord(input));
	}

	/*
	 * Simply applying window seems legitimate to me, 
	 * but it counts "a " as 0 instead of 1 so whatever.
	 * Use a bottom-up approach to get possible speed up, 
	 * don't forget to absorb all the spaces at the end first.
	 */
	public static int lengthOfLastWord(String s){
		int index = s.length()-1, length = 0;
		for(;index >= 0 && s.charAt(index) == ' ';--index);
		for(;index >= 0 && s.charAt(index) != ' ';--index, ++length);
		return length;
	}
}
