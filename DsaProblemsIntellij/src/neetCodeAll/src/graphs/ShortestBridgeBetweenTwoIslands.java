package graphs;

import java.util.LinkedList;
import java.util.Queue;

class ShortestBridgeBetweenTwoIslands {
	public static void main(String[] args) {
		int graph[][] = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
		ShortestBridgeBetweenTwoIslands s = new ShortestBridgeBetweenTwoIslands();
		System.out.println(s.shortestBridge(graph));
	}

	public int shortestBridge(int[][] grid) {
		int n = grid.length;
		Queue<int[]> q = new LinkedList<>();
		boolean found = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (found && grid[i][j] ==

						1)
					q.add(new int[] { i, j }); // for 2nd island

				if (!found && grid[i][j] == 1) {
					// before only went inside, after changed to 2, then made it true
					dfs(grid, i, j, n);
					found = true;
				}

			}
		}
		return bfs(q, grid, n);
	}

	public void dfs(int grid[][], int row, int col, int n) {
		if (row < 0 || col < 0 || col >= n || row >= n || grid[row][col] == 0 || grid[row][col] == 2)
			return;
		grid[row][col] = 2;
		dfs(grid, row, col + 1, n);
		dfs(grid, row, col - 1, n);
		dfs(grid, row - 1, col, n);
		dfs(grid, row + 1, col, n);
	}

	public int bfs(Queue<int[]> q, int grid[][], int n) {
		int ans = 0; // will be incremented after all the bfs nodes of node 'x' are visited.
		while (!q.isEmpty()) { // traversing from 2nd island back to 1st, if next or previous row or col is in
								// 1st island, i.e marked 2, we have our ans.
			int size = q.size();
			for (int c = 0; c < size; c++) {
				int arr[] = q.poll();
				int i = arr[0];
				int j = arr[1];
				// checking for 1st island nodes.
				if ((i > 0 && grid[i - 1][j] == 2) || (i < n - 1 && grid[i + 1][j] == 2)
						|| (j > 0 && grid[i][j - 1] == 2) || (j < n - 1 && grid[i][j + 1] == 2))
					return ans;
				if (i > 0 && grid[i - 1][j] == 0) {
					grid[i - 1][j] = 1;
					q.add(new int[] { i - 1, j });
				}
				if (i < n - 1 && grid[i + 1][j] == 0) {
					grid[i + 1][j] = 1;
					q.add(new int[] { i + 1, j });
				}
				if (j > 0 && grid[i][j - 1] == 0) {
					grid[i][j - 1] = 1;
					q.add(new int[] { i, j - 1 });
				}
				if (j < n - 1 && grid[i][j + 1] == 0) {
					grid[i][j + 1] = 1;
					q.add(new int[] { i, j + 1 });
				}
			}

			ans++; // how many flips
		}
		return 0;
	}
}