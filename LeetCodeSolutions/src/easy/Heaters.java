package easy;

import java.util.Arrays;
import java.util.TreeSet;

public class Heaters {
	/**
	 * Winter is coming! Your first job during the contest is to design a standard heater with 
	 * fixed warm radius to warm all the houses.
	 * 
	 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum 
	 * radius of heaters so that all houses could be covered by those heaters.
	 * 
	 * So, your input will be the positions of houses and heaters seperately, and your expected 
	 * output will be the minimum radius standard of heaters.
	 * 
	 * Note:
	 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
	 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
	 * As long as a house is in the heaters' warm radius range, it can be warmed.
	 * All the heaters follow your radius standard and the warm radius will the same.
	 * 
	 * Example 1:
	 * Input: [1,2,3],[2]
	 * Output: 1
	 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 
	 * standard, then all the houses can be warmed.
	 * 
	 * Example 2:
	 * Input: [1,2,3,4],[1,4]
	 * Output: 1
	 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 
	 * standard, then all the houses can be warmed.
	 **/
	public static void main(String[] args) {
		System.out.println(findRadius(new int[]{1,2,3}, new int[]{2}));
		System.out.println(findRadius(new int[]{1,2,3,4}, new int[]{1,4}));
	}

	/*
	 * 1. two pointers ~20ms
	 * 2. One sort and binary search ~26ms
	 * 3. TreeSet ~120ms
	 */
	public static int findRadius(int[] houses, int[] heaters) {
		return treeSet(houses, heaters);
	}

	public static int twoPointers(int[] houses, int[] heaters) {
		Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int i = 0, ans = 0;
        for ( int house : houses ) {
        	while ( i < heaters.length-1 && heaters[i] + heaters[i+1] <= house * 2 ) ++i;
        	ans = Math.max(ans, Math.abs(heaters[i] - house));
        }
        
		return ans;
	}

	// the solution by shawnghao and StefanPochmann
	public static int binarySearch(int[] houses, int[] heaters) {
		Arrays.sort(heaters);
		int result = 0;

		for (int house : houses) {
			int index = Arrays.binarySearch(heaters, house);
			if ( index < 0 ) {	// binarySearch would return (-(insertion point) - 1)
				index = ~index;	
				int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
				int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

				result = Math.max(result, Math.min(dist1, dist2));
			}
		}

		return result;
	}

	public static int treeSet(int[] houses, int[] heaters) {
		TreeSet<Integer> set = new TreeSet<>();
		for ( int heater : heaters ) set.add(heater);

		int ans = 0;
		for ( int house : houses ) {
			Integer left = set.floor(house);
			Integer right = set.ceiling(house);
			if ( left == null ) {
				ans = Math.max(ans, right-house);
			} else if ( right == null ) {
				ans = Math.max(ans, house-left);
			} else {
				ans = Math.max(ans, Math.min(house-left, right-house));
			}
		}
		return ans;
	}
}
