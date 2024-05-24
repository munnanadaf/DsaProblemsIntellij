package graphs;

class IslandPerimeter {
	public static int islandPerimeter(int[][] grid) {
		if (grid == null)
			return 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1)
					return getPerimeter(grid, i, j);
			}
		}
		return 0;
	}

	public static int getPerimeter(int[][] grid, int row, int col) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)
			return 1;
		if (grid[row][col] == -1)
			return 0;
		grid[row][col] = -1;
		int perimeter = 0;
		return perimeter = getPerimeter(grid, row + 1, col) + getPerimeter(grid, row - 1, col)
				+ getPerimeter(grid, row, col + 1) + getPerimeter(grid, row, col - 1);
	}
}