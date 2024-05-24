package dp;

import java.util.Arrays;

class NumberOfDiceRollsWithTargetSum {
	final int mod = (int) Math.pow(10, 9) + 7;

	public int numRollsToTarget(int n, int k, int target) {
		int dp[][] = new int[n + 1][target + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		return recursion(dp, n, k, target);

	}

	public int recursion(int dp[][], int n, int k, int target) {
		if (n == 0 && target == 0)
			return 1; // 1 way.
		if (n == 0 || target < 0)
			return 0; // not possible with cur combination of dices
		if (dp[n][target] != -1)
			return (int) (dp[n][target] % mod);
		int ways = 0;
		for (int i = 1; i <= k; i++)
			ways = (ways + recursion(dp, n - 1, k, target - i)) % mod; // return res in 1e9+7;
		dp[n][target] = ways;
		return dp[n][target];
	}
}