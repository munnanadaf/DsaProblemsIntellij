package dp2d;

class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int res = Integer.MIN_VALUE;
		int m = matrix.length;
		int n = matrix[0].length;
		Integer visited[][] = new Integer[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1')
					// how many squares we can make, starting from cur i,j as topLeft cell.
					res = Math.max(res, dfs(matrix, i, j, visited));
			}
		}
		// bcz we are getting square size (side size = side*side)
		return res * res;
	}

	public int dfs(char[][] matrix, int i, int j, Integer[][] visited) {
		if (i >= matrix.length || j >= matrix[0].length || i < 0 || j < 0 || matrix[i][j] == '0')
			return 0;
		if (visited[i][j] != null)
			return visited[i][j];
		int down = dfs(matrix, i + 1, j, visited);
		int right = dfs(matrix, i, j + 1, visited);
		int diag = dfs(matrix, i + 1, j + 1, visited);
		// Math.min bcz we want complete square value, if any of bottom, right, diag
		// value is zero, we cant make square.
		// if all are one, then its like 1+1, i.e 2 = 2*2 cell.
		return visited[i][j] = 1 + Math.min(Math.min(down, right), diag);
	}
}