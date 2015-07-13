package easy;

import java.util.Arrays;

public class ValidSudoku {

	/**
	 * Determine if a Sudoku is valid, according to : Sudoku Puzzles - The Rules.
	 * http://sudoku.com.au/TheRules.aspx
	 * 
	 * The Sudoku board could be partially filled, where empty cells are filled with
	 * the character '.'. Note:
	 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the 
	 * filled cells need to be validated.
	 */
	public static void main(String[] args) {
		char[][] board = new char[][]{
				".87654321".toCharArray(),
				"2........".toCharArray(),
				"3........".toCharArray(),
				"4........".toCharArray(),
				"5........".toCharArray(),
				"6........".toCharArray(),
				"7........".toCharArray(),
				"8........".toCharArray(),
				"9........".toCharArray()};
		System.out.println(isValidSudoku(board));
	}

	/*
	 * Coming up with the index is the most difficult part for this problem.
	 * For the square checking, try to do a K-map and generate the index order.
	 */
	public static boolean isValidSudoku(char[][] board){
		boolean[] number = new boolean[9];
		//Horizontal check
		for( int i = 0; i < board.length ; ++i ){
			for( int j = 0; j < board[0].length; ++j ){
				if( board[i][j] == '.' ) continue;
				else if( number[board[i][j]-'1'] ) return false;
				else number[board[i][j]-'1'] = true;
			}
			Arrays.fill(number, false);
		}
		
		//Vertical check
		for( int i = 0; i < board.length ; ++i ){
			for( int j = 0; j < board[0].length; ++j ){
				if( board[j][i] == '.' ) continue;
				else if( number[board[j][i]-'1'] ) return false;
				else number[board[j][i]-'1'] = true;
			}
			Arrays.fill(number, false);
		}
		
		//Square check
		for( int i = 0; i < board.length; i += 3 ){
			for( int j = 0; j < board[0].length; j += 3 ){
				for( int a = 0; a < 3; ++a ){
					for( int b = 0; b < 3; ++b ){
						if( board[i+a][j+b] == '.' ) continue;
						else if( number[board[i+a][j+b]-'1'] ) return false;
						else number[board[i+a][j+b]-'1'] = true;
					}
				}
				Arrays.fill(number, false);
			}
		}
		return true;
	}
}
