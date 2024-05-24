package dp;

import java.util.Arrays;

class UniquePaths {
	public int uniquePaths(int m, int n) {
		int dp[][] = new int[m + 1][n + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		return totalPaths(0, 0, m, n, dp);
	}

	public static int totalPaths(int i, int j, int m, int n, int dp[][]) {
		if (i > m || j > n)
			return 0;
		if (i == m - 1 && j == n - 1)
			return 1;
		if (dp[i][j] != -1)
			return dp[i][j];
		return dp[i][j] = totalPaths(i, j + 1, m, n, dp) + totalPaths(i + 1, j, m, n, dp);
	}

	public int uniquePath(int m, int n) {
		int N = n + m - 2;
		int r = m - 1;
		double res = 1;

		for (int i = 1; i <= r; i++)
			res = res * (N - r + i) / i;
		return (int) res;
	}
}