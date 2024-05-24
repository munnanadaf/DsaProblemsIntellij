package arrays;

class BuyAndSellStocks2 {
	public int maxProfit(int[] prices) {
		int curPrice = prices[0];
		int n = prices.length;
		int profit = 0;
		for (int i = 1; i < n; i++) {
			if (curPrice < prices[i]) {
				profit += prices[i] - curPrice;
				curPrice = prices[i];
			} else {
				curPrice = prices[i];
			}
		}
		return profit;
	}
}