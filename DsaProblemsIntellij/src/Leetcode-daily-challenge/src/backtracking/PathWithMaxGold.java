package backtracking;

class PathWithMaxGold {
	public int getMaximumGold(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean visited[][] = new boolean[m][n];
		int maxGold = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && grid[i][j] != 0)
					maxGold = Math.max(maxGold, helpFindMaxGold(grid, visited, i, j));
			}
		}
		return maxGold < 0 ? 0 : maxGold;
	}

	public int helpFindMaxGold(int[][] grid, boolean visited[][], int row, int col) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0
				|| visited[row][col])
			return 0;
		visited[row][col] = true;
		int up = helpFindMaxGold(grid, visited, row - 1, col);
		int down = helpFindMaxGold(grid, visited, row + 1, col);
		int left = helpFindMaxGold(grid, visited, row, col - 1);
		int right = helpFindMaxGold(grid, visited, row, col + 1);
		visited[row][col] = false;
		return grid[row][col] + Math.max(up, Math.max(down, Math.max(left, right)));
	}
}