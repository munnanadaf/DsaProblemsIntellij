package graphs;

import java.util.LinkedList;
import java.util.Queue;

class ShortestPathInABinaryMatrix {
	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
		System.out.println(shortestPathBinaryMatrix(arr));
	}

	public static int shortestPathBinaryMatrix(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return -1;
		}

		int ans = 0;

		int row = grid.length;
		int col = grid[0].length;

		if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
			return -1;
		}

		int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

		boolean[][] visited = new boolean[row][col];

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			ans++;

			for (int i = 0; i < size; i++) {
				int[] curPos = queue.poll();

				if (curPos[0] == row - 1 && curPos[1] == col - 1) {
					return ans;
				}

				for (int[] dir : dirs) {
					int nextX = curPos[0] + dir[0];
					int nextY = curPos[1] + dir[1];

					if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited[nextX][nextY]
							|| grid[nextX][nextY] == 1) {
						continue;
					}

					visited[nextX][nextY] = true;
					queue.offer(new int[] { nextX, nextY });
				}
			}
		}

		return -1;
	}

}