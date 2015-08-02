package medium;

import java.util.Arrays;
import java.util.Stack;

public class WordSearch {

	/**
	 * Given a 2D board and a word, find if the word exists in the grid. The word can
	 *  be constructed from letters of sequentially adjacent cell, where "adjacent"
	 *  cells are those horizontally or vertically neighboring. The same letter cell
	 *  may not be used more than once. For example, Given board = 
	 *  [
	 *  	["ABCE"],
	 *  	["SFCS"],
	 *  	["ADEE"]
	 *  ]
	 *   word = "ABCCED", -> returns true.
	 *   word = "SEE", -> returns true.
	 *   word = "ABCB", -> returns false.
	 **/
	public static void main(String[] args) {
		char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(exist(board, "ABCCED"));
		System.out.println(exist(board, "SEE"));
		System.out.println(exist(board, "ABCB"));
		System.out.println(exist(new char[][]{{'A'}}, "A"));
		System.out.println(exist(new char[][]{{'A', 'B'}, {'C', 'D'}}, "CDBA"));
		System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS"));
	}

	/*
	 * DFS should be the only solution since the its backtracking nature is perfectly fit to this problem.
	 * In LeetCode OJ, those test cases favors recursive solution. The recursive solution here will modify
	 * the input char[][] array in order to save extra memory spaces.
	 */
	public static class Tuple{
		int x, y, z;
		public Tuple(int x, int y, int z){
			this.x = x; this.y = y; this.z = z;
		}
	}
	
	public static boolean exist(char[][] board, String word){
		if( board.length == 0 || board[0].length == 0 ) return false;
		boolean[][] visited = new boolean[board.length][board[0].length];
		char[] w = word.toCharArray();
		Stack<Tuple> stack = new Stack<Tuple>();
		for( int i = 0; i < board.length; ++i ){
			for( int j = 0; j < board[0].length; ++j ){
				if( board[i][j] == w[0] ){
					stack.push(new Tuple(i, j, 0));
					while( !stack.isEmpty() ){
						Tuple top = stack.peek();
						if( visited[top.x][top.y] ){
							visited[top.x][top.y] = false;
							stack.pop();
							continue;
						}
						visited[top.x][top.y] = true;
						if( top.z+1 == w.length ) return true;
						if( top.y-1 >= 0 && !visited[top.x][top.y-1] && board[top.x][top.y-1] == w[top.z+1])
							stack.push(new Tuple(top.x, top.y-1, top.z+1));
						if( top.y+1 < board[0].length && !visited[top.x][top.y+1] && board[top.x][top.y+1] == w[top.z+1])
							stack.push(new Tuple(top.x, top.y+1, top.z+1));
						if( top.x-1 >= 0 && !visited[top.x-1][top.y] && board[top.x-1][top.y] == w[top.z+1])
							stack.push(new Tuple(top.x-1, top.y, top.z+1));
						if( top.x+1 < board.length && !visited[top.x+1][top.y] && board[top.x+1][top.y] == w[top.z+1])
							stack.push(new Tuple(top.x+1, top.y, top.z+1));
					}
					for( boolean[] v : visited )
						Arrays.fill(v, false);
				}
			}
		}
		return false;
	}

	public static boolean existDFS(char[][] board, String word){
		char[] w = word.toCharArray();
		for( int y = 0; y < board.length; ++y )
			for( int x = 0; x < board[0].length; ++x )
				if( existDFS(board, x, y, w, 0) ) return true;
		return false;
	}

	public static boolean existDFS(char[][] board, int x, int y, char[] word, int i){
		if( i == word.length ) return true;
		if( x < 0 || y < 0 || x >= board[0].length || y >= board.length || board[y][x] != word[i]) 
			return false;
		board[y][x] ^= 256;
		boolean exist = existDFS(board, x+1, y, word, i+1)
				|| existDFS(board, x-1, y, word, i+1)
				|| existDFS(board, x, y+1, word, i+1)
				|| existDFS(board, x, y-1, word, i+1);
		board[y][x] ^= 256;
		return exist;
	}
}
