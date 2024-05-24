package arrays;

public class SearchIn2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		int row = 0;
		int col = matrix[0].length - 1;

		while (col >= 0 && row < matrix.length) {
			if (matrix[row][col] < target)
				row++;
			if (matrix[row][col] > target)
				col--;
			if (matrix[row][col] == target)
				return true;
		}

		return false;
	}

}
