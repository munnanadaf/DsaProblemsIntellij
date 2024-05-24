package graphs;

// from left bottom cell to right bottom cell, only having 0 values
class ShortestPathBinaryMatrix {
	public static void main(String[] args) {
		int grid[][] = { { 0, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 } };
		System.out.println(shortestPathBinaryMatrix(grid));
	}

	public static int shortestPathBinaryMatrix(int[][] grid) {
		return bfs(grid, 0, 0, grid.length, Integer.MAX_VALUE);
	}

	public static int bfs(int[][] grid, int row, int col, int n, int ans) {
		if(row == n-1)
		if (row >= n || col >= n || grid[row][col + 1] != 0)
			return 0;
		int right = Integer.MAX_VALUE;
		int down = Integer.MAX_VALUE;
		int rightDown = Integer.MAX_VALUE;
			down = 1 + bfs(grid, row + 1, col, n, ans);
			right = 1 + bfs(grid, row, col + 1, n, ans);
			rightDown = 1 + bfs(grid, row + 1, col + 1, n, ans);
		return ans = Math.min(right, Math.min(down, rightDown));
	}
}