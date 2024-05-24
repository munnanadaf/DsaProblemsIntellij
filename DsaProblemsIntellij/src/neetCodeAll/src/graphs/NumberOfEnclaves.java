package graphs;

// only surrounded by 0 in all for directions. i.e cant walk on boundary areas those islands we have to return.
class NumberOfEnclaves {
	public int numEnclaves(int[][] grid) {
		int enclaves = 0;
		int m = grid.length;
		int n = grid[0].length;

// marking boundary connected islands as invalid, then checking for no. of enclaves, in a dfs manner just like no of islands case
		for (int i = 0; i < m; i++) {
			dfs(grid, i, 0);
			dfs(grid, i, n - 1);
		}

		for (int i = 0; i < n; i++) {
			dfs(grid, 0, i);
			dfs(grid, m - 1, i);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1)
					enclaves++;
			}
		}

		return enclaves;
	}

	public void dfs(int[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
			return;
		grid[i][j] = 0;
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}
}