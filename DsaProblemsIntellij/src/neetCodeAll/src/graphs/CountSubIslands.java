package graphs;

class CountSubIslands {
	public int countSubIslands(int[][] grid1, int[][] grid2) {
		int m = grid1.length;
		int n = grid1[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid1[i][j] == 0 && grid2[i][j] == 1) // if not island, sink all connected non sub island land.
					dfs(grid2, i, j);
			}
		}

		int subIslands = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid2[i][j] == 1)
					subIslands++;
				dfs(grid2, i, j); // sink that complete sub island, as we have visited already.
			}
		}
		return subIslands;
	}

	public void dfs(int[][] grid2, int i, int j) {
		if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length || grid2[i][j] == 0)
			return;
		grid2[i][j] = 0; // make them sink, non sub island/ mark them visisted.
		// sink all connected land.
		dfs(grid2, i + 1, j);
		dfs(grid2, i - 1, j);
		dfs(grid2, i, j + 1);
		dfs(grid2, i, j - 1);
	}
}