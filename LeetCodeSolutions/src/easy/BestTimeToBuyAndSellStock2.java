package easy;

public class BestTimeToBuyAndSellStock2 {
	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many transactions as 
	 * you like (ie, buy one and sell one share of the stock multiple times). However, you may 
	 * not engage in multiple transactions at the same time (ie, you must sell the stock before 
	 * you buy again).
	 **/
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{1,2,4,23,43,123,2}));
	}

	public static int maxProfit(int[] prices) {
		int sum = 0;
		
		for ( int i = 0; i < prices.length-1; ++i ) {
			if ( prices[i] - prices[i+1] < 0 ) 
				sum += prices[i+1] - prices[i]; 
		}
		
		return sum;
	}
}
