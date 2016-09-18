package easy;

public class BestTimeToBuyAndSellStock {
	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
	 * design an algorithm to find the maximum profit.
	 **/
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
		System.out.println(maxProfit(new int[]{7,6,4,3,1}));
	}

	/*
	 * Since gain can only be obtained with a starting point with lower value and ending point with higher,
	 * the search can be reset once the ending price is lower than starting.
	 */
	public static int maxProfit(int[] prices) {
		int max = 0, start = 0;
		for ( int i = 1; i < prices.length; ++i ) {
			int gain = prices[i] - prices[start];
			if ( gain < 0 ) start = i;
			else if ( gain > max ) max = gain;
		}
		return max;
	}
}
