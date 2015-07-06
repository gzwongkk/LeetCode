package solutions;

public class LongestPalindromicSubtring {
	
	/*
	 * Given a string S, find the longest palindromic substring in S.
	 * You may assume that the maximum length of S is 1000, and there
	 * exists one unique longest palindromic substring.
	 */

	public static void main(String[] args) {
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		System.out.println(longestPalindrome(s));
	}
	
	/*
	 * Uses the method of "Stars and Bars" in combinatorics to construct the solution.
	 * O(n^2) in time yet O(1) in space
	 */
	public static String longestPalindrome(String s){
		if( s == null )
			return null;
		int n = s.length();
		if( n == 0 ) return "";
		String longest = s.substring(0, 1);
		int maxLength = 1;
		for(int i = 0; i < n-1; ++i){
			String possible = expandAroundCenter(s, n, i, i);
			if(possible.length() > maxLength){
				longest=possible;
				maxLength = possible.length();
			}
			possible = expandAroundCenter(s, n, i, i+1);
			if(possible.length() > maxLength){
				longest=possible;
				maxLength = possible.length();
			}
		}
		return longest;
	}
	
	public static String expandAroundCenter(String s, int n, int l, int r){
		while( l >= 0 && r < n && s.charAt(l)==s.charAt(r)){
			--l;
			++r;
		}
		return s.substring(l+1,  r);
	}
	
	/*
	 * O(n^2) in time and space with Dynamic programming.
	 */
	/*
	public static String longestPalindrome(String s){
		if( s == null )
			return null;
		boolean[][] palindrome = new boolean[1000][1000];
		int size = s.length(), start = 0, length = 1;
		for( int i = 0; i < size-1; ++i ){
			palindrome[i][i] = true;
			if( s.charAt(i) == s.charAt(i+1) ){
				palindrome[i][i+1] = true;
				start = i;
				length = 2;
			}
		}
		palindrome[size-1][size-1] = true;
		for( int i = 3; i <= size ; ++i ){
			for( int j = 0; j < size - i + 1; ++j ){
				int k = i + j - 1;
				if( s.charAt(j) == s.charAt(k) && palindrome[j+1][k-1]){
					palindrome[j][k] = true;
					start = j;
					length = i;
				}
			}
		}
		return s.substring(start, start + length);
	}*/
}
