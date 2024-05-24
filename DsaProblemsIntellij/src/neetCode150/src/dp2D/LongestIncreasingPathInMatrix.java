package dp2D;

class LongestIncreasingPathInMatrix {
	int lip = 0;
	int m;
	int n;

	public int longestIncreasingPath(int[][] matrix) {
		m = matrix.length;
		n = matrix[0].length;
		int[][] dp = new int[m][n];
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				dfs(matrix, dp, r, c, -1);
			}
		}
		return lip;
	}

	public int dfs(int[][] matrix, int[][] dp, int r, int c, int prev) {
		if (r < 0 || c < 0 || r >= m || c >= n || matrix[r][c] <= prev)
			return 0;
		if (dp[r][c] != 0) {
			lip = Math.max(lip, dp[r][c]);
			return dp[r][c];
		}
		int res = 1;
		res = Math.max(res, 1 + dfs(matrix, dp, r + 1, c, matrix[r][c]));
		res = Math.max(res, 1 + dfs(matrix, dp, r, c + 1, matrix[r][c]));
		res = Math.max(res, 1 + dfs(matrix, dp, r - 1, c, matrix[r][c]));
		res = Math.max(res, 1 + dfs(matrix, dp, r, c - 1, matrix[r][c]));
		dp[r][c] = res;
		lip = Math.max(lip, dp[r][c]);
		return res;
	}
}