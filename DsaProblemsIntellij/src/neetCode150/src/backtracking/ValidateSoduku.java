package backtracking;

import java.util.HashSet;
import java.util.Set;

class ValidateSoduku {
//	public boolean isValidSudoku(char[][] board) {
//		for (int i = 0; i < 9; i++) {
//			HashSet<Character> rows = new HashSet<Character>();
//			HashSet<Character> columns = new HashSet<Character>();
//			HashSet<Character> cube = new HashSet<Character>();
//			for (int j = 0; j < 9; j++) {
//				if (board[i][j] != '.' && !rows.add(board[i][j]))
//					return false;
//				if (board[j][i] != '.' && !columns.add(board[j][i]))
//					return false;
//				int RowIndex = 3 * (i / 3);
//				int ColIndex = 3 * (i % 3);
//				if (board[RowIndex + j / 3][ColIndex + j % 3] != '.'
//						&& !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))
//					return false;
//			}
//		}
//		return true;
//	}

	public boolean isValidSudoku1(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> rows = new HashSet<>();
			HashSet<Character> cols = new HashSet<>();
			HashSet<Character> box = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !rows.add(board[i][j]))
					return false;
//				swapping i & j as we are doing it in a single loop i.e for row & col using 'j' variable
				if (board[j][i] != '.' && !cols.add(board[j][i]))
					return false;
				int subBoxRowIndex = 3 * (i / 3);
				// to set rows of box as 0, 3, 6
				int subBoxColIndex = 3 * (i % 3);
				// to set cols of box as 0,3,6
//				and makes sure all sub boxes columns of same row are covered properly
				if (board[subBoxRowIndex + j / 3][subBoxColIndex + j % 3] != '.'
						&& !box.add(board[subBoxRowIndex + j / 3][subBoxColIndex + j % 3]))
					return false;
			}
		}

		return true;
	}
	
	
	//block better understanding
//    for (int i = 0; i < rows; i = i + 3) {
//        for (int j = 0; j < cols; j = j + 3) {
//            if (!checkBlock(i, j, board)) {
//                return false;
//            }
//        }
//    }
	
	public boolean checkBlock(int idxI, int idxJ, char[][] board) {
        Set<Character> blockSet = new HashSet<>();
        int rows = idxI + 3;
        int cols = idxJ + 3;
        for (int i = idxI; i < rows; i++) {
            for (int j = idxJ; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (blockSet.contains(board[i][j])) {
                    return false;
                }

                blockSet.add(board[i][j]);
            }
        }

        return true;
    }

}