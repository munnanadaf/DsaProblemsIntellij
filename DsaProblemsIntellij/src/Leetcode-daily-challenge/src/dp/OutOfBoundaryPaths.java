package dp;

import java.util.Arrays;

public class OutOfBoundaryPaths {

	public static final int mod = (int) 1e9 + 7;

	public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		long dp[][][] = new long[m][n][maxMove + 1];
		for (long[][] row : dp) {
			for (long col[] : row)
				Arrays.fill(col, -1);
		}
		return (int) totalPaths(m, n, maxMove, startRow, startColumn, dp) % mod;
	}

	public static long totalPaths(int m, int n, int maxMove, int row, int col, long[][][] dp) {
		if (row < 0 || row >= m || col < 0 || col >= n)
			return 1;
		if (dp[row][col][maxMove] != -1)
			return dp[row][col][maxMove];
		if (maxMove == 0) {
			if (row < 0 || col < 0 || col >= n || row >= m)
				return 1;
			return 0;
		}
		long up = totalPaths(m, n, maxMove - 1, row - 1, col, dp) % mod;
		long down = totalPaths(m, n, maxMove - 1, row + 1, col, dp) % mod;
		long right = totalPaths(m, n, maxMove - 1, row, col + 1, dp) % mod;
		long left = totalPaths(m, n, maxMove - 1, row, col - 1, dp) % mod;
		return dp[row][col][maxMove] = (up + down + right + left) % mod;
	}
}