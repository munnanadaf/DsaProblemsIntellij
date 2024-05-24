package dp;

class CoinChange2UnlmSupply {
	public int change(int amount, int[] coins) {
		int n = coins.length;
		Integer dp[][] = new Integer[n + 1][amount + 1];
		return coinChangeHelp(coins, coins.length, amount, dp);
	}

	public int coinChangeHelp(int[] coins, int n, int amount, Integer dp[][]) {
		if (n == 0)
			return 0;
		if (amount == 0) {
			return 1;
		}
		if (dp[n][amount] != null)
			return dp[n][amount];
		if (coins[n - 1] > amount) {
			return dp[n][amount] = coinChangeHelp(coins, n - 1, amount, dp);
		}
		return dp[n][amount] = coinChangeHelp(coins, n, amount - coins[n - 1], dp)
				+ coinChangeHelp(coins, n - 1, amount, dp);
	}
}