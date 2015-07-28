package medium;

import java.util.Stack;

public class NumberOfIsland {

	/**
	 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by
	 * water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of
	 * the grid are all surrounded by water.
	 * Example 1:
	 * 11110
	 * 11010
	 * 11000
	 * 00000
	 * Answer: 1
	 * 
	 * Example 2:
	 * 11000
	 * 11000
	 * 00100
	 * 00011
	 * Answer: 3
	 **/
	public static void main(String[] args) {
		char[][] grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		System.out.println(numIslands(grid));
	}

	/*
	 * This problem critically solve the 3-match or candy crush or puzzle and dragon problem.
	 * Depth first search is used to check connectivity. Ce n'est pas difficile quoi!
	 */
	public static int numIslands(char[][] grid){
		if( grid.length == 0 ) return 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Stack<Integer> stack = new Stack<Integer>();
		int islands = 0;
		for( int i = 0; i < grid.length; ++i ){
			for( int j = 0; j < grid[0].length; ++j ){
				if( !visited[i][j] && grid[i][j] == '1' ){
					stack.push(j);
					stack.push(i);
					while( !stack.isEmpty() ){
						int x = stack.pop(), y = stack.pop();
						if( visited[x][y] ) continue;
						visited[x][y] = true;
						if( grid[x][y] == '1' ){
							if( y-1 >= 0 && !visited[x][y-1] ){
								stack.push(y-1);
								stack.push(x);
							}
							if( y+1 < grid[0].length && !visited[x][y+1] ){
								stack.push(y+1);
								stack.push(x);
							}
							if( x-1 >= 0 && !visited[x-1][y] ){
								stack.push(y);
								stack.push(x-1);
							}
							if( x+1 < grid.length && !visited[x+1][y] ){
								stack.push(y);
								stack.push(x+1);
							}
						}
					}
					++islands;
				}
			}
		}
		return islands;
	}
}
