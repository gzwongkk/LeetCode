package easy;

public class CompareVersionNumbers {

	/**
	 * Compare two version numbers version1 and version2.
	 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
	 * You may assume that the version strings are non-empty and contain only digits and the . character.
	 * The . character does not represent a decimal point and is used to separate nunber sequences.
	 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level
	 * revision of the second first-level revision.
	 * Here is an example of version numbers ordering:
	 * 0.1 < 1.1 < 1.2 < 13.37
	 */
	public static void main(String[] args) {
		System.out.println(compareVersion("1.0.654034251894298162168984621","1.0.654034251894298162168984620"));
	}

	/*
	 * Super long and complicated solution, but it accepts overflow input, which is quite important since it 
	 * is asking for value comparison but not data type conversion.
	 * Other solution would be using split and parseInt.
	 */
	public static int compareVersion(String version1, String version2){
		int size1 = version1.length(), size2 = version2.length();
		int v1Start = 0, v2Start = 0, v1End = 0, v2End = 0;
		while( v1End < size1 && v2End < size2 ){
			while( v1End < size1 && version1.charAt(v1End) != '.' )	++v1End;
			while( v2End < size2 && version2.charAt(v2End) != '.' )	++v2End;
			while( v1Start < size1 && version1.charAt(v1Start) == '0' )	++v1Start;
			while( v2Start < size2 && version2.charAt(v2Start) == '0' )	++v2Start;
			if( v1End-v1Start < v2End-v2Start ) return -1;
			else if( v1End-v1Start > v2End-v2Start ) return 1;
			while( v1Start < v1End && v2Start < v2End ){
				if( version1.charAt(v1Start) < version2.charAt(v2Start) ) return -1;
				else if( version1.charAt(v1Start) > version2.charAt(v2Start) ) return 1;
				else{ ++v1Start; ++v2Start;	}
			}
			if( v1Start != v1End ) return -1;
			if( v2Start != v2End ) return 1;
			v1Start = ++v1End;
			v2Start = ++v2End;
		}
		if( v1End < size1 ){
			while( v1End < size1 && (version1.charAt(v1End) == '0' || version1.charAt(v1End) == '.') )
				++v1End;
			if( v1End < size1 )	return 1;
		}
		if( v2End < size2 ){
			while( v2End < size2 && (version2.charAt(v2End) == '0' || version2.charAt(v2End) == '.') )
				++v2End;
			if( v2End < size2 )	return -1;
		}
		return 0;
	}
	
	public static int compareVersionSplit(String version1, String version2){
		String[] v1 = version1.split("\\.");
	    String[] v2 = version2.split("\\.");
	    
	    for ( int i = 0; i < Math.max(v1.length, v2.length); i++ ) {
	        int num1 = i < v1.length ? Integer.parseInt( v1[i] ) : 0;
	        int num2 = i < v2.length ? Integer.parseInt( v2[i] ) : 0;
	        if ( num1 < num2 ) {
	            return -1;
	        } else if ( num1 > num2 ) {
	            return +1;
	        }
	    } 
	    
	    return 0;
	}
}
