package easy;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {

	/**
	 * Given a sorted integer array without duplicates, return the summary of its ranges.
	 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
	 */
	
	public static void main(String[] args) {
		int[] input = new int[]{0,1};
		for(String s : summaryRanges(input)){
			System.out.println(s);
		}
	}

	/*
	 * Similar to sliding window, more of a programming work than thinking.
	 */
	public static List<String> summaryRanges(int[] nums){
		LinkedList<String> ans = new LinkedList<String>();
		if( nums.length == 0 ) return ans;
		int start = nums[0], current = nums[0];
		for( int i = 0; i < nums.length; ++i ){
			if( current < nums[i] && current != nums[i]-1 ){
				if( start == current )
					ans.add(""+start);
				else
					ans.add(""+start+"->"+current);
				start = nums[i];
			}
			current = nums[i];
		}
		if( start == current )
			ans.add(""+start);
		else
			ans.add(""+start+"->"+current);
		return ans;
	}
}
