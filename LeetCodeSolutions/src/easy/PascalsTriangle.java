package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	/**
	 * Given numRows, generate the first numRows of Pascal's triangle.
	 * For example, given numRows = 5, Return
		[
		     [1],
		    [1,1],
		   [1,2,1],
		  [1,3,3,1],
		 [1,4,6,4,1]
		]
	 */
	public static void main(String[] args) {
		int numRows = 15;
		for(List<Integer> list : generate(numRows)){
			for( Integer i : list ){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	/*
	 * Quote from wikipedia, "Each number in the triangle is the sum of the two
	 * directly above it." The key is to develop a strategy to do so in a list.
	 */
	public static List<List<Integer>> generate(int numRows){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for( int i = 0; i < numRows ; ++i ){
			row.add(0, 1);
			for( int j = 1; j < row.size()-1; ++j )
				row.set(j, row.get(j)+row.get(j+1));
			list.add(new ArrayList<Integer>(row));
		}
		return list;
	}
}
