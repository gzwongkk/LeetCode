package medium;

import java.util.Stack;

public class SurroundedRegions {

	/**
	 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
	 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
	 * For example,
	 * X X X X
	 * X O O X
	 * X X O X
	 * X O X X
	 * 
	 * After running your function, the board should be:
	 * X X X X
	 * X X X X
	 * X X X X
	 * X O X X
	 **/
	public static void main(String[] args) {
		char[][] board = new char[][]{{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
		for( char[] row : board ){
			for( char col : row )
				System.out.print(col +" ");
			System.out.println();
		}
		System.out.println();
		solve(board);
		for( char[] row : board ){
			for( char col : row )
				System.out.print(col +" ");
			System.out.println();
		}
	}

	/*
	 * Hard typing is much faster than array-substitution. This algorithm is to find all regions having
	 * connections with 'O' elements at the edge of the board, since they cannot be captured.
	 * Another way is to use the set union data structure. Path compression makes it costs practically 
	 * constant time.
	 */
	public static class Pair{
		int x, y;
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void solve(char[][] board){
		if( board.length == 0 || board[0].length == 0 ) return;
		for( int i = 0; i < board.length; ++i ){
			if( board[i][0] == 'O' ) solveBFS(board, i, 0);
			if( board[i][board[0].length-1] == 'O' ) solveBFS(board, i, board[0].length-1);
		}
		for( int i = 0; i < board[0].length; ++i ){
			if( board[0][i] == 'O' ) solveBFS(board, 0, i);
			if( board[board.length-1][i] == 'O' ) solveBFS(board, board.length-1, i);
		}
		for( int i = 0; i < board.length; ++i )
			for( int j = 0; j < board[0].length; ++j )
				if( board[i][j] == 'F' ) board[i][j] = 'O';
				else board[i][j] = 'X';
	}

	public static void solveBFS(char[][] board, int x, int y){
		Stack<Pair> stack = new Stack<Pair>();
		stack.push(new Pair(x,y));
		while( !stack.isEmpty() ){
			Pair region = stack.pop();
			board[region.x][region.y] = 'F';
			if( region.x-1 >= 0 && board[region.x-1][region.y] == 'O' ) 
				stack.push(new Pair(region.x-1, region.y));
			if( region.y-1 >= 0 && board[region.x][region.y-1] == 'O' ) 
				stack.push(new Pair(region.x, region.y-1));
			if( region.x+1 < board.length && board[region.x+1][region.y] == 'O' ) 
				stack.push(new Pair(region.x+1, region.y));
			if( region.y+1 < board[0].length && board[region.x][region.y+1] == 'O' ) 
				stack.push(new Pair(region.x, region.y+1));
		}
	}
	
	public class unionSet{
		int[] unionSet;
		boolean[] hasEdgeO;
		
		private void union(int x, int y){
			int rootX = findSet(x);
			int rootY = findSet(y);
			unionSet[rootX] = rootY;
			hasEdgeO[rootY] = hasEdgeO[rootX] || hasEdgeO[rootY];
		}
		
		private int findSet(int x){
			if( unionSet[x] == x ) return x;
			unionSet[x] = findSet(unionSet[x]);	//Path Compression => Practically constant runtime
			return unionSet[x];
		}
		
		public void solve(char[][] board){
			if( board.length == 0 || board[0].length == 0 ) return;
			
			int height = board.length, width = board[0].length;
			unionSet = new int[height * width];
			hasEdgeO = new boolean[unionSet.length];
			for( int i = 0; i < unionSet.length; ++i ) unionSet[i] = i;
			for( int i = 0; i < hasEdgeO.length; ++i ) {
				int x = i / width, y = i % width;
				hasEdgeO[i] = ( board[x][y] == 'O' && ( x == 0 || x == height-1 || y == 0 || y == width-1 ));
			}
			
			for( int i = 0; i < unionSet.length; ++i ){
				int x = i / width, y = i % width, up = x-1, right = y+1;
				if( up >= 0 && board[x][y] == board[up][y] ) union(i, i-width);
				if( right < width && board[x][y] == board[x][right] ) union(i, i+1);
			}
			
			for( int i = 0; i < unionSet.length; ++i ){
				int x = i / width, y = i % width;
				if( board[x][y] == 'O' && !hasEdgeO[findSet(i)] ) board[x][y] = 'X';
			}
		}
	}
}
