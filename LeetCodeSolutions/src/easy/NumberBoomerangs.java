package easy;

import java.util.HashMap;

public class NumberBoomerangs {
	/**
	 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) 
	 * such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
	 * 
	 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are 
	 * all in the range [-10000, 10000] (inclusive).
	 **/
	public static void main(String[] args) {
		System.out.println(numberOfBoomerangs(new int[][]{{0,0},{1,0},{2,0}}));
	}

	/*
	 * The distance can be squared because exact values are not important. Then use a map to store them.
	 * Remark: clearing the map ~120ms while creating new maps ~200ms
	 */
	public static int numberOfBoomerangs(int[][] points) {
		int num = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for ( int[] a : points ) {
			for ( int[] b : points ) {
				int distance = euclideanSquared(a, b);
				int value = map.getOrDefault(distance, 0); 
				num += 2 * value;
				map.put(distance, value+1);
			}
			map.clear();
		}
		return num;
	}
	
	public static int euclideanSquared(int[] a, int[] b){
		int x = a[0]-b[0], y = a[1]-b[1];
		return x*x + y*y;
	}
}
