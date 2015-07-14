package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle2 {

	/**
	 * Given an index k, return the kth row of the Pascal's triangle.
	 * For example, given k = 3,
	 * Return [1,3,3,1].
	 * Note:
	 * COuld you optimize your algorithm to use only O(k) extra space?
	 **/
	public static void main(String[] args) {
		int rowIndex = 10;
		for( Integer i : getRow(rowIndex) )
			System.out.print(i+" ");
	}

	/*
	 * 1) Use the fact that nCr = nC(r-1) * n-r / r to do an O(1) space solution.
	 * 		Theoretically costs less time, but multiplication and division might be a pain.
	 * 2) Recursive solution as in PascalsTriangle. Uses only addition though.
	 */
	public static List<Integer> getRow(int rowIndex){
		List<Integer> row = new ArrayList<Integer>(rowIndex+1);
		if( rowIndex >= 0 ) row.add(1);
		for( int i = 1; i <= rowIndex; ++i ){
			if( i <= rowIndex/2 )
				row.add((int)((long)row.get(i-1)*(rowIndex-i+1)/i));
			else
				row.add(row.get(rowIndex-i));
		}
		return row;
	}
	
	public static List<Integer> getRowRecursive(int rowIndex){
		Integer[] row = new Integer[rowIndex+1];
		Arrays.fill(row, 0);
		row[0] = 1;
		for( int i = 1; i <= rowIndex; ++i )
			for( int j = i; j > 0; --j )
				row[j] = row[j] + row[j-1];
		return Arrays.asList(row);
	}
}
