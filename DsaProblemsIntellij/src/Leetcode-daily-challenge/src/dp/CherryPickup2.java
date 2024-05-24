package dp;

class CherryPickup2 {
	public int cherryPickup(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		Integer[][][] dp = new Integer[m][n][n]; // for robo1 & robo2, we need columns c1 & c2.
		return dfs(grid, m, n, 0, 0, n - 1, dp); // starting row, robo1 col, robo2 col, dp
	}

	public int dfs(int[][] grid, int m, int n, int r, int c1, int c2, Integer[][][] dp) {
		if (r == m)
			return 0;
		if (dp[r][c1][c2] != null)
			return dp[r][c1][c2];

		int ans = 0;
		for (int i = -1; i <= 1; i++) { // for each robo1 selected cell
			for (int j = -1; j <= 1; j++) { // robo2 selection possibilities
				int nc1 = c1 + i, nc2 = c2 + j; // selected cells
				if (nc1 >= 0 && nc1 < n && nc2 >= 0 && nc2 < n) {
					ans = Math.max(ans, dfs(grid, m, n, r + 1, nc1, nc2, dp)); // considering max of all the other
																				// columns possibilities for the single
																				// row.
				}
			}
		}
		int cherries = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2]; // max ans + curGrid cell cherries
		return dp[r][c1][c2] = ans + cherries;
	}
}