package graphs;

public class CheckIfMoveIsLegal {
	public boolean isLegalMove(char board[][], int rMove, int cMove, char color) {
		return dfs(board, 1, 1, rMove, cMove, color, 0) || dfs(board, 1, 0, rMove, cMove, color, 0)
				|| dfs(board, 1, -1, rMove, cMove, color, 0) || dfs(board, -1, 1, rMove, cMove, color, 0)
				|| dfs(board, -1, 0, rMove, cMove, color, 0) || dfs(board, -1, -1, rMove, cMove, color, 0)
				|| dfs(board, 0, 1, rMove, cMove, color, 0) || dfs(board, 0, -1, rMove, cMove, color, 0); // no 0,0 bcz
																											// it is
																											// allowed
																											// to change
																											// color,
																											// given
																											// cell.
	}

	public boolean dfs(char board[][], int nextRow, int nextCol, int row, int col, char color, int count) {
		row = row + nextRow;
		col = col + nextCol;
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '.')
			return false;
		if (board[row][col] == color) // given cell next color shouldnot be same, so if it is same, this direction is
										// already invalid
			return count >= 1;
		return dfs(board, nextRow, nextCol, row, col, color, count);
	}

}
