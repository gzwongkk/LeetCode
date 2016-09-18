package easy;

public class ReverseVowelsOfAString {
	/**
	 * Write a function that takes a string as input and reverse only the vowels of a string.
	 * 
	 * Given s = "hello", return "holle".
	 * Given s = "leetcode", return "leotcede".
	 * 
	 * The vowels does not include the letter "y".
	 **/
	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("leetcode"));
	}

	/*
	 * Classic two pointers application. 
	 * A naive way would be extracting the vowels, reverse them and plug them back.
	 */
	public static String reverseVowels(String s) {
		char[] c = s.toCharArray();
		int i = 0, j = c.length - 1;
		while ( i < j ) {
			for (; i < j && !isVowel(c[i]); ++i);
			for (; i < j && !isVowel(c[j]); --j);
			
			char k = c[i];
			c[i] = c[j];
			c[j] = k;
			
			++i;
			--j;
		}
		return new String(c);
	}
	
	public static String reverseVowelsNaive(String s) {
		StringBuilder vowels = new StringBuilder();
		char[] c = s.toCharArray();
		for ( int i = 0; i < c.length; ++i )
			if ( isVowel(c[i]) )
				vowels.append(c[i]);
		
		vowels = vowels.reverse();
		
		for ( int i = 0, j = 0; i < c.length; ++i )
			if ( isVowel(c[i]) )
				c[i] = vowels.charAt(j++);
		
		return new String(c);
	}
	
	public static boolean isVowel ( char c ) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
				c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	}
}
