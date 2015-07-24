package medium;

public class RotateImage {

	/**
	 * You are given an n x n 2D matrix representing an image.
	 * Rotate the image by 90 degrees (clockwise).
	 * Could you do this in-place?
	 **/
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{1,0,0,0,2},
				{0,1,1,1,0},
				{0,1,1,1,1},
				{0,1,1,1,0},
				{3,0,0,0,4}
		};
		for( int j = 0; j < matrix.length; ++j ){
			for( int i = 0; i < matrix[0].length; ++i )
				System.out.print(matrix[j][i]);
			System.out.println();
		}
		
		System.out.println();
		rotate(matrix);
		for( int j = 0; j < matrix.length; ++j ){
			for( int i = 0; i < matrix[0].length; ++i )
				System.out.print(matrix[j][i]);
			System.out.println();
		}
	}

	/*
	 * Flip it diagonally and then vertically in the middle. Voila.
	 * But in programming sense (in order to make use of array of arrays),
	 * Flip it upside down and then diagonally.
	 */
	public static void rotate(int[][] matrix){
		for( int i = 0; i < matrix.length/2; ++i ){
			int[] temp = matrix[i];
			matrix[i] = matrix[matrix.length - i - 1];
			matrix[matrix.length - i - 1] = temp;
		}
		
		for( int i = 0; i < matrix.length; ++i ){
			for( int j = 0; j < i; ++j ){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
