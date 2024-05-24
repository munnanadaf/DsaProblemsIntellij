package dp;

import java.util.Arrays;

class MinimumPathSum {
	public static void main(String[] args) {
		int grid[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(minPathSum(grid) + " ************ ");
	}

//	public static int minPathSum(int[][] arr) {
//		int m = arr.length;
//		int n = arr[0].length;
//		return f(m - 1, n - 1, arr);
//	}
//
//	public static int f(int i, int j, int arr[][]) {
//		if (i == 0 && j == 0)
//			return arr[0][0];
//		if (i < 0 || j < 0)
//			return 999;
//		int up = arr[i][j] + f(i - 1, j, arr);
//		int left = arr[i][j] + f(i, j - 1, arr);
//		return Math.min(up, left);
//	}

	static int[][] dp;

	public static int minPathSum(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		dp = new int[m][n];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		return sum(m - 1, n - 1, arr);
	}

	public static int sum(int i, int j, int arr[][]) {
		if (i == 0 && j == 0)
			return arr[0][0];
		if (i < 0 || j < 0)
			return 999;
		if (dp[i][j] != -1)
			return dp[i][j];
		int up = arr[i][j] + sum(i - 1, j, arr);
		int left = arr[i][j] + sum(i, j - 1, arr);
		return dp[i][j] = Math.min(up, left);
	}
}