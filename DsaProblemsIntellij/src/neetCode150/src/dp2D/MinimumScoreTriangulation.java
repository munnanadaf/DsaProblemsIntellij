package dp2D;

import java.util.Arrays;

class MinimumScoreTriangulation {
	public int minScoreTriangulation(int[] values) {
		int n = values.length;
		int dp[][] = new int[n][n];
		for (int row[] : dp)
			Arrays.fill(row, -1);
		return solve(values, dp, 1, n - 1);
	}

	public int solve(int[] values, int dp[][], int l, int r) {
		if (l >= r)
			return 0;
		if (dp[l][r] != -1)
			return dp[l][r];
		int min = Integer.MAX_VALUE;
		for (int k = l; k < r; k++) {
			int cost = values[l - 1] * values[k] * values[r] + solve(values, dp, l, k) + solve(values, dp, k + 1, r);
			min = Math.min(min, cost);
		}
		return dp[l][r] = min;
	}
}