package easy;

public class StrStr {

	/**
	 * Implement strStr().
	 * Returns the index of the first occurrence of needle in haystack,
	 * or -1 if needle is not part of haystack.
	 */
	public static void main(String[] args) {
		String haystack = "is this what you mean?", needle = "this";
		System.out.println(strStr(haystack, needle));
		haystack = "mississippi";
		needle = "issip";
		System.out.println(strStr(haystack, needle));
		haystack = "aaa";
		needle = "aaaa";
		System.out.println(strStr(haystack, needle));
	}

	/*
	 * Brute force is implemented. The first one is extremely slow, still figuring out the reason.
	 * The second is so much faster, even better than the use of HashMap, which is not surprising
	 * because pushing strings into HashMap means the whole string is processed.
	 * The third one is almost the same as second. I guess that one extra variable did cost a lot.
	 * 
	 * Advanced algorithms like KMP, Rabin-Karp, and the Boyer-Moore can also solve this easily.
	 */
	public static int strStr(String haystack, String needle){
		int size = haystack.length(), length = needle.length();
		if( length == 0 ) return 0;
		else if( length > size ) return -1;
		for( int h = 0, ans = 0; ans < size ; h = ++ans){
			int n = 0;
			while( h < size && n < length && haystack.charAt(h) == needle.charAt(n)){
				++h;
				++n;
			}
			if( n == length ) return ans;
		}
		return -1;
	}

	public static int strStrClean(String haystack, String needle){
		int size = haystack.length(), length = needle.length();
		if( length == 0 ) return 0;
		for( int start = 0; true; ++start) {
			for( int end = 0; true; ++end ){
				if( end == length ) return start;
				if( start+end == size ) return -1;
				if( haystack.charAt(start+end) != needle.charAt(end) ) break;
			}
		}
	}

	public static int strStrRevised(String haystack, String needle) {
		int size = haystack.length(), length = needle.length();
		if( length == 0 ) return 0;
		else if( length > size ) return -1;
		for( int ans = 0; ans < size-length+1 ; ++ans){
			int n = 0;
			while( ans+n < size && n < length 
					&& haystack.charAt(ans+n) == needle.charAt(n)){
				++n;
			}
			if( n == length ) return ans;
		}
		return -1;
	}
}
