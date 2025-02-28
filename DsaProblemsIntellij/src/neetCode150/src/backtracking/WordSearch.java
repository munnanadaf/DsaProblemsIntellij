package backtracking;

class WordSearch {
	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (helpSearch(board, word, i, j, m, n, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean helpSearch(char[][] board, String word, int i, int j, int m, int n, int cur) {
		if (cur >= word.length())
			return true;
		if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(cur))
			return false;
		boolean exist = false;
		if (board[i][j] == word.charAt(cur)) {
			// marking it visited
			board[i][j] += 100;
			exist = helpSearch(board, word, i + 1, j, m, n, cur + 1) 
					|| helpSearch(board, word, i, j + 1, m, n, cur + 1)
					|| helpSearch(board, word, i - 1, j, m, n, cur + 1)
					|| helpSearch(board, word, i, j - 1, m, n, cur + 1);
			// backtracking
			board[i][j] -= 100;
		}
		return exist;
	}
}