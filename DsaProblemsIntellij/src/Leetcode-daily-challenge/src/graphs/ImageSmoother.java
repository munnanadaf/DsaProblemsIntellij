package graphs;

class ImageSmoother {
	public int[][] imageSmoother(int[][] img) {
		int m = img.length;
		int n = img[0].length;
		int res[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = getAverage(img, i, j);
			}
		}
		return res;
	}

	public int getAverage(int[][] img, int row, int col) {
		int dirs[][] = { { 1, 0 }, { 0, 1 }, { 0, 0 }, { 1, 1 }, { -1, 0 }, { 0, -1 }, { -1, -1 }, { 1, -1 },
				{ -1, 1 } };
		int sum = 0;
		int n = 0;
		for (int dir[] : dirs) {
			int newRow = row + dir[0];
			int newCol = col + dir[1];
			if (newRow < 0 || newRow >= img.length || newCol < 0 || newCol >= img[0].length)
				continue;
			sum += img[newRow][newCol];
			n++;
		}
		return sum / n;
	}
}