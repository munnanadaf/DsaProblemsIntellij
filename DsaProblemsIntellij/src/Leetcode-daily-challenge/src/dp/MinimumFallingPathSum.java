package dp;

import java.util.Arrays;
// -100>=matrix[i][j]<=100, so for dp dont use -1 as default value
class MinimumFallingPathSum {

	public int minFallingPathSum(int[][] matrix) {
		int minPathSum = Integer.MAX_VALUE;
		int m = matrix.length;
		int n = matrix[0].length;
		int dp[][] = new int[m][n];
		for (int row[] : dp)
			Arrays.fill(row, Integer.MAX_VALUE); // 49th test case was failing bcz array can contain -1, so using maxInt
													// value
		for (int i = 0; i < n; i++) {
			minPathSum = Math.min(minPathSum, getMinSum(matrix, 0, i, dp));
		}
		return minPathSum;
	}

	public int getMinSum(int[][] matrix, int row, int col, int dp[][]) {
		if (col < 0 || col >= matrix[0].length)
			return Integer.MAX_VALUE;
		if (row == matrix.length - 1)
			return dp[row][col] = matrix[row][col];
		if (dp[row][col] != Integer.MAX_VALUE)
			return dp[row][col];
		int bottom = getMinSum(matrix, row + 1, col, dp);
		int bottomLeft = getMinSum(matrix, row + 1, col - 1, dp);
		int bottomRight = getMinSum(matrix, row + 1, col + 1, dp);
		return dp[row][col] = Math.min(Math.min(bottom, bottomRight), bottomLeft) + matrix[row][col];
	}
}