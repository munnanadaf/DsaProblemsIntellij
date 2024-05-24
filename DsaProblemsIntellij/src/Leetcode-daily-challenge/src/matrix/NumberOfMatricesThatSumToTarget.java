package matrix;

class NumberOfMatricesThatSumToTarget {
	public int numSubmatrixSumTarget(int[][] matrix, int target) {
		int res = 0;
		int m = matrix.length;
		int n = matrix[0].length;

		// prefix sum for each row of matrix // col prefix sum
		for (int row = 0; row < m; row++) {
			for (int col = 1; col < n; col++) {
				matrix[row][col] = matrix[row][col] + matrix[row][col - 1];
			}
		}

// calculate sum of each submatrix and check if it is equal to target
		for (int colStart = 0; colStart < n; colStart++) {
			for (int colEnd = colStart; colEnd < n; colEnd++) {
				for (int rowStart = 0; rowStart < m; rowStart++) {
					int sum = 0;
					for (int rowEnd = rowStart; rowEnd < m; rowEnd++) {
						sum = sum + matrix[rowEnd][colEnd] - (colStart > 0 ? matrix[rowEnd][colStart - 1] : 0);
						if (sum == target)
							res++;
					}
				}
			}
		}
		return res;

	}
}