package graphs;

import java.util.PriorityQueue;

class SwimInRisingWater {

	public static void main(String[] args) {
		int grid[][] = { { 0, 2 }, { 1, 3 } };
		System.out.println(swimInWater(grid));
	}

	private static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static int swimInWater(int[][] grid) {
		int n = grid.length;
		boolean visited[][] = new boolean[n][n];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		pq.add(new int[] { 0, 0, grid[0][0] });
		visited[0][0] = true;

		while (!pq.isEmpty()) {
			int[] data = pq.poll();
			for (int[] d : dir) {
				int newR = data[0] + d[0];
				int newC = data[1] + d[1];
				int depth = data[2];
				if (newR < 0 || newR >= n || newC < 0 || newC >= n)
					continue;
				if (!visited[newR][newC]) {
					visited[newR][newC] = true;
					int newDepth = Math.max(depth, grid[newR][newC]);
					if (newR == n - 1 && newC == n - 1)
						return newDepth;
					pq.add(new int[] { newR, newC, newDepth });
				}
			}
		}
		return 0;
	}
}