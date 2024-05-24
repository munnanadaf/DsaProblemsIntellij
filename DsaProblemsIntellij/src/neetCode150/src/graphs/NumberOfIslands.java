package graphs;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands {

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;

		int[][] vis = new int[m][n];
		int count = 0;
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if (vis[row][col] == 0 && grid[row][col] == '1') {
					count++;
					bfs(row, col, vis, grid);
				}
			}
		}

		return count;
	}

	public static void bfs(int row, int col, int[][] vis, char[][] grid) {
		vis[row][col] = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { row, col });
		int m = grid.length;
		int n = grid[0].length;

		int dirs[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		while (!q.isEmpty()) {
			int size = q.size();
			int pos[] = q.poll();

			for (int i = 0; i < size; i++) {
				for (int[] r : dirs) {
					int nRow = pos[0] + r[0];
					int nCol = pos[1] + r[1];

					if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == '1'
							&& vis[nRow][nCol] == 0) {
						vis[nRow][nCol] = 1;
						q.add(new int[] { nRow, nCol });
					}
				}
			}
		}
	}
}