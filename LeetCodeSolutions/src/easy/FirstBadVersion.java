package easy;

public class FirstBadVersion {
	/**
	 * You are a product manager and currently leading a team to develop a new product. Unfortunately,
	 * the latest version of your product fails the quality check. Since each version is developed based
	 * on the previous version, all the versions after a bad version are also bad.
	 * Suppose you have n Versions [1, 2, ..., n] and you want to find out the first bad one, which causes
	 * all the following ones to be bad.
	 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement
	 * a function to find the first bad version. You should minimize the number of calls to the API.
	 **/
	public static void main(String[] args) {
		FirstBadVersion case_1 = new FirstBadVersion(3);
		System.out.println(case_1.firstBadVersion(6));
	}
	
	public int firstBad;
	public FirstBadVersion(int firstBad){
		this.firstBad = firstBad;
	}
	
	public boolean isBadVersion(int version){
		return version >= firstBad;
	}

	/*
	 * Binary Search with a little twist in implementation: required an API.
	 * Notice that using low+(high-low)/2 is better than (high+low)/2 since it may overflow.
	 */
	public int firstBadVersion(int n){
		int i = 1, j = n;
		while( i < j ){
			int k = i+(j-i)/2;
			if( isBadVersion(k) ) j = k; 
			else i = k+1;
		}
		return i;
	}
}
