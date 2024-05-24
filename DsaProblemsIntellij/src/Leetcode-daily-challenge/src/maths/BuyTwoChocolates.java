package maths;

class BuyTwoChocolates {
	public int buyChoco(int[] prices, int money) {
		int min1 = Integer.MAX_VALUE - 1;
		int min2 = Integer.MAX_VALUE;

		int n = prices.length;
		for (int i = 0; i < n; i++) {
			if (prices[i] <= min1) {
				min2 = min1;
				min1 = prices[i];
			}
			if (prices[i] < min2 && prices[i] > min1)
				min2 = prices[i];
		}
		int origMoney = money;
		money = money - min1 - min2;
		return money >= 0 ? money : origMoney;
	}
}