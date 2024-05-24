package graphs;

import java.util.*;
import java.io.*;

public class WallsAndGates {
	public static int[][] wallsAndGates(int[][] a, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 0)
					dfs(a, i, j, 0);
			}
		}
		return a;
	}

	public static void dfs(int a[][], int row, int col, int count) {
		int n = a.length;
		int m = a[0].length;
		if (row < 0 || row >= n || col < 0 || col >= m || a[row][col] < count)
			return;
		a[row][col] = count;
		dfs(a, row + 1, col, count + 1);
		dfs(a, row - 1, col, count + 1);
		dfs(a, row, col + 1, count + 1);
		dfs(a, row, col - 1, count + 1);
		return;
	}
}
