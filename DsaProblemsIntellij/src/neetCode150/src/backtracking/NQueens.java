package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		for (List<String> list : solveNQueens(4)) {
			System.out.println(list);
		}
	}

	public static List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		List<List<String>> res = new ArrayList<>();
		for (char[] row : board)
			Arrays.fill(row, '.');
		helpSolve(board, res, n, 0);
		return res;
	}

	public static void helpSolve(char[][] board, List<List<String>> res, int n, int col) {
		if (col > n)
			return;
		if (n == col) {
			res.add(construct(board));
			return;
		}
		for (int row = 0; row < n; row++) {
			if (isSafe(board, row, col, n)) {
				board[row][col] = 'Q';
				helpSolve(board, res, n, col + 1);
				board[row][col] = '.';
			}
		}
	}

	private static boolean isSafe(char[][] board, int row, int col, int n) {
		int tmpRow = row;
		int tmpCol = col;
//		if (row < n && row >= 0 && col < n && col >= 0) {
			while (row >= 0 && col >= 0) {
//			upper diagonal
				if (board[row][col] == 'Q')
					return false;
				row--;
				col--;
			}

			row = tmpRow;
			col = tmpCol;
			while (row < n && col >= 0) {
//			lower diagonal
				if (board[row][col] == 'Q')
					return false;
				row++;
				col--;
			}

			row = tmpRow;
			col = tmpCol;
			while (col >= 0) {
				if (board[row][col] == 'Q')
					return false;
				col--;

			}
//		}

		return true;
	}

	private static List<String> construct(char[][] board) {
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			res.add(s);
		}
		return res;
	}
}