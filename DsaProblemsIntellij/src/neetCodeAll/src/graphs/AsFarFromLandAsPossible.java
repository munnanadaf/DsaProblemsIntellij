package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
	class Pair {
		int key;
		int value;

		Pair(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public int maxDistance(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final int[] dirs = { 0, 1, 0, -1, 0 };
		Queue<Pair> q = new LinkedList<>();
		int water = 0;

		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				if (grid[i][j] == 0)
					++water;
				else
					q.offer(new Pair(i, j));

		if (water == 0 || water == m * n)
			return -1;

		int ans = 0;

		for (int d = 0; !q.isEmpty(); ++d)
			for (int sz = q.size(); sz > 0; --sz) {
				Pair pair = q.poll();
				final int row = pair.key;
				final int col = pair.value;
				ans = d;
				for (int k = 0; k < 4; ++k) {
					final int curRow = row + dirs[k];
					final int curCol = col + dirs[k + 1];
					if (curRow < 0 || curRow == m || curCol < 0 || curCol == n)
						continue;
					if (grid[curRow][curCol] > 0)
						continue;
					q.offer(new Pair(curRow, curCol));
					grid[curRow][curCol] = 2; // Mark as visited.
				}
			}

		return ans;
	}
}