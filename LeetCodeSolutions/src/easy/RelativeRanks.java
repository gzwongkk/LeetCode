package easy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class RelativeRanks {
	/**
	 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, 
	 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
	 * 
	 * Input: [5, 4, 3, 2, 1]
	 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
	 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
	 * For the left two athletes, you just need to output their relative ranks according to their scores.
	 **/
	public static void main(String[] args) {
		for( String s : findRelativeRanks(new int[]{5,4,3,2,1})){
			System.out.println(s);
		}
		for( String s : findRelativeRanksPriorityQueue(new int[]{5,4,3,2,1})){
			System.out.println(s);
		}
		for( String s : findRelativeRanksTreeMap(new int[]{5,4,3,2,1})){
			System.out.println(s);
		}
	}

	/*
	 * All O(n log n)
	 * 1. sorting in pairs with lambda expression
	 * 2. priority queue
	 * 3. Tree map
	 * 
	 * For the test cases used, TreeMap has the fastest performance.
	 */
	public static String[] findRelativeRanks(int[] nums) {
		int[][] ranks = new int[nums.length][2];
		for ( int i = 0; i < ranks.length; ++i ) {
			ranks[i][0] = nums[i];
			ranks[i][1] = i;
		}
		
		Arrays.sort(ranks, (a, b) -> b[0]-a[0]);
		
		String[] relativeRanks = new String[ranks.length];
		for ( int i = 0; i < ranks.length; ++i ) {
			if ( i < 3 ) {
				if ( i == 0 ) relativeRanks[ranks[i][1]] = "Gold Medal";
				else if ( i == 1 ) relativeRanks[ranks[i][1]] = "Silver Medal";
				else relativeRanks[ranks[i][1]] = "Bronze Medal";
			} else relativeRanks[ranks[i][1]] = "" + (i+1);
		}
		return relativeRanks;
	}
	
	public static String[] findRelativeRanksPriorityQueue(int[] nums) {
		PriorityQueue<java.util.AbstractMap.SimpleEntry<Integer, Integer>> q = new PriorityQueue<>((a,b)->(b.getKey()-a.getKey()));
		for ( int i = 0; i < nums.length; ++i ) q.add(new java.util.AbstractMap.SimpleEntry<>(nums[i],i));
		
		String[] relativeRanks = new String[nums.length];
		for ( int i = 0; i < nums.length; ++i ) {
			if ( i < 3 ) {
				if ( i == 0 ) relativeRanks[q.poll().getValue()] = "Gold Medal";
				else if ( i == 1 ) relativeRanks[q.poll().getValue()] = "Silver Medal";
				else relativeRanks[q.poll().getValue()] = "Bronze Medal";
			} else relativeRanks[q.poll().getValue()] = "" + (i+1);
		}
		return relativeRanks;
	}

	public static String[] findRelativeRanksTreeMap(int[] nums) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for ( int i = 0; i < nums.length; ++i ) map.put(nums[i],i);
		
		String[] relativeRanks = new String[nums.length];
		for ( int i = 0; i < nums.length; ++i ) {
			if ( i < 3 ) {
				if ( i == 0 ) relativeRanks[map.pollLastEntry().getValue()] = "Gold Medal";
				else if ( i == 1 ) relativeRanks[map.pollLastEntry().getValue()] = "Silver Medal";
				else relativeRanks[map.pollLastEntry().getValue()] = "Bronze Medal";
			} else relativeRanks[map.pollLastEntry().getValue()] = "" + (i+1);
		}
		return relativeRanks;
	}
}
