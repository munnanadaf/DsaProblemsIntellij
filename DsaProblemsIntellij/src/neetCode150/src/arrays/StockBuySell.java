package arrays;

public class StockBuySell {
	public static void main(String[] args) {
		int a [] = {1,4,2};
		int b[] = {3,2,6,5,0,3};
		System.out.println(maxProfit1(b));
	}

	public static int maxProfit(int[] prices) {
		int i = 1, j = prices.length - 2;
		int low = prices[0], high = prices[prices.length - 1];
		while (i <= j) {
			if (prices[i] < low) {
				low = prices[i];
				i++;
			} else
				i++;
			if (prices[j] > high) {
				high = prices[j];
				j--;
			} else
				j--;
		}
		int res = high - low;
		return res < 0 ? 0 : res;
	}
	
	 public static int maxProfit1(int prices[]) {
	        int minprice = Integer.MAX_VALUE;
	        int maxprofit = 0;
	        for (int i = 0; i < prices.length; i++) {
	            if (prices[i] < minprice)
	                minprice = prices[i];
	            else if ((prices[i] - minprice) > maxprofit)
	                maxprofit = prices[i] - minprice;
	        }
	        return maxprofit;
	    }
}
