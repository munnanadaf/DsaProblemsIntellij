package graphs;

class FloodFill {
	public static void main(String[] args) {
		int a[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		for (int[] row : floodFill(a, 1, 1, 2)) {
			for (int ele : row) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		floodFill(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}

//	dfs
	private static void floodFill(int[][] image, int sr, int sc, int newColor, int oldColor) {
		if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor
				|| image[sr][sc] == newColor) {
			return;
		} else {
			image[sr][sc] = newColor;
			floodFill(image, sr + 1, sc, newColor, oldColor);
			floodFill(image, sr - 1, sc, newColor, oldColor);
			floodFill(image, sr, sc + 1, newColor, oldColor);
			floodFill(image, sr, sc - 1, newColor, oldColor);
		}
	}

	class Solution {
		int[] DIRS = { 0, 1, 0, -1, 0 };
		int m, n;

		public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
			if (image[sr][sc] == newColor)
				return image; // same color -> no need to replace
			m = image.length;
			n = image[0].length;
			dfs(image, sr, sc, image[sr][sc], newColor);
			return image;
		}

		void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
			if (r < 0 || r == m || c < 0 || c == n || image[r][c] != oldColor)
				return;
			image[r][c] = newColor; // also mean we marked it as visited!
			for (int i = 0; i < 4; i++)
				dfs(image, r + DIRS[i], c + DIRS[i + 1], oldColor, newColor);
		}
	}
}