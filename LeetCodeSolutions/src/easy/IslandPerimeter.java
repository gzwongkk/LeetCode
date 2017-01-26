package easy;

public class IslandPerimeter {
	/**
	 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
	 * Grid cells are connected horizontally/vertically(not diagonally). The grid is completely surrounded by water, and
	 * there is exactly one island(i.e., one or more connected land cells). The island doesn't have "lakes" (water inside 
	 * that isn't connected to the water around the island). One cell is a square with side length 1. The grid is 
	 * rectangular, width and height don't exceed 100. Determine the perimeter of the island.
	 * Example:
	 *  [[0,1,0,0],
	 *   [1,1,1,0],
	 *   [0,1,0,0],
	 *   [1,1,0,0]]
	 * Answer: 16
	 **/
	
	public static void main(String[] args) {
		System.out.println(islandPerimeter(new int[][]{new int[]{0, 1, 0, 0}, new int[]{1, 1, 1, 0}, new int[]{0, 1, 0, 0}, new int[]{1, 1, 0, 0}}));
	}
	
	/*
	 * Whenever two grids combine, two sides vanish.  
	 */
	public static int islandPerimeter(int[][] grid) {
		int lands = 0, neighbors = 0;
		for ( int i = 0; i < grid.length; ++i ) {
			for ( int j = 0; j < grid[0].length; ++j ) {
				if ( grid[i][j] == 1 ) {
					++lands;
					if ( i+1 < grid.length && grid[i+1][j] == 1 ) ++neighbors;
					if ( j+1 < grid[0].length && grid[i][j+1] == 1 ) ++neighbors;
				}
			}
		}
		return lands*4-neighbors*2;
	}
}
