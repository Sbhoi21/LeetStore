class Solution {
    public int maxProfit(int[] prices) {
        int max = prices[prices.length - 1], diff = 0;
		for (int i = prices.length - 1; i >= 0; i--) {
			if (max < prices[i]) {
				max = prices[i];
			}
			if ((max - prices[i]) > diff) {
				diff = max - prices[i];
			}
		}
		return diff;
    }
}