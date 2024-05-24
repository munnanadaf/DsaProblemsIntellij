package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PacificAtlanticWaterFlow {
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		List<List<Integer>> res = new ArrayList<>();
		int rowLen = heights.length;
		int colLen = heights[0].length;

		boolean[][] pacific = new boolean[rowLen][colLen];
		boolean[][] atlantic = new boolean[rowLen][colLen];

		for (int i = 0; i < colLen; i++) {
			dfs(heights, pacific, 0, i, Integer.MIN_VALUE);
			dfs(heights, atlantic, rowLen - 1, i, Integer.MIN_VALUE);
		}

		for (int i = 0; i < rowLen; i++) {
			dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
			dfs(heights, atlantic, i, colLen - 1, Integer.MIN_VALUE);
		}

		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (pacific[i][j] && atlantic[i][j]) {
					res.add(Arrays.asList(i, j));
				}
			}
		}

		return res;

	}

	public void dfs(int[][] heights, boolean[][] visited, int r, int c, int prev) {
		if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length)
			return;
		if (heights[r][c] < prev || visited[r][c])
			return;
		visited[r][c] = true;

		dfs(heights, visited, r + 1, c, heights[r][c]);
		dfs(heights, visited, r - 1, c, heights[r][c]);
		dfs(heights, visited, r, c + 1, heights[r][c]);
		dfs(heights, visited, r, c - 1, heights[r][c]);
	}
}