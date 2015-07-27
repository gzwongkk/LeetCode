package medium;

public class ReverseWordsInString {

	/**
	 * Given an input string, reverse the string word by word. For example, 
	 * Given s = "the sky is blue", return "blue is sky the".
	 * Clarification:
	 * 	What constitutes a word?
	 * 		A sequence of non-space characters constitutes a word.
	 * 	Could the input string contain leading or trailing spaces?
	 * 		Yes, However, your reversed string should not contain leading or trailing spaces.
	 * 	How about multiple spaces between two words?
	 * 		Reduce them to a single space in the reversed string.
	 **/
	public static void main(String[] args) {
		System.out.println(reverseWords("  the sky is blue  "));
	}

	/*
	 * I am almost trained to use bottom up approach while handling decode problems.
	 * The trim function in String is the silver bullet for heading and trailing spaces,
	 * as well as all spaces evil string. However it might get banned, so a basic version
	 * is also painfully completed. After torturing, I fight back with a time-minimized 
	 * solution. Turns out trim() doesn't cost too much time.
	 */
	public static String reverseWords(String s){
		char[] str = s.trim().toCharArray();
		if( str.length == 0 ) return "";
		StringBuilder ans = new StringBuilder();
		int start = str.length - 1, end = str.length;
		while( start >= 0 ){
			if( str[start] == ' ' ){
				if( str[start+1] != ' ' ){
					for( int i = start+1; i < end; ++i ) ans.append(str[i]);
					ans.append(' ');
				}
				end = start; 
			}
			--start;
		}
		for( int i = 0; i < end; ++i ) ans.append(str[i]);
		return ans.toString();
	}
	
	public static String reverseWordsStrict(String s){
		if( s.length() == 0 ) return "";
		String ans = "";
		char[] str = s.toCharArray();
		int start = ( str[str.length - 1] != ' ' )? str.length - 1	: str.length - 2;
		int end   = ( str[str.length - 1] != ' ' )? str.length		: str.length - 1;
		while( start >= 0 ){
			if( str[start] == ' ' ){
				if( str[start+1] != ' ' ) ans += s.substring( start+1, end ) + ' ';
				end = start; 
			}
			--start;
		}
		if( str[0] != ' ' ) return ans + s.substring( start+1, end );
		else return ans.length() == 0? ans: ans.substring(0, ans.length()-1);
	}
}
