package backtracking;

class SodukuSolver {
	public static void main(String[] args) {
		char board[][] = 
			{ 
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } 
			};
		solveSudoku(board);
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean isvalid(char board[][], char c, int row_i, int col_i) {
		for (int i = 0; i < 9; ++i) {
			if (board[row_i][i] == c)
				return false;
			else if (board[i][col_i] == c)
				return false;
			else {
				int newRow = 3 * (row_i / 3) + i / 3;
				int newCol = 3 * (col_i / 3) + i % 3;
				if (board[newRow][newCol] == c)
					return false;
			}
		}
		return true;
	}

	public static boolean solver(char board[][], int rstart) {
		for (int row = rstart; row < 9; ++row) {
			for (int col = 0; col < 9; ++col) {
				if (board[row][col] == '.') {
					for (char c = '1'; c <= '9'; ++c) {
						if (isvalid(board, c, row, col)) {
							board[row][col] = c;
							if (solver(board, row))
								return true;
							else
								board[row][col] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public static void solveSudoku(char board[][]) {
		solver(board, 0);
	}
	
//	public void solveSudoku(char[][] board) {
//        if(board == null || board.length == 0)
//            return;
//        solve(board);
//    }
//    
//    public boolean solve(char[][] board){
//        for(int i = 0; i < board.length; i++){
//            for(int j = 0; j < board[0].length; j++){
//                if(board[i][j] == '.'){
//                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
//                        if(isValid(board, i, j, c)){
//                            board[i][j] = c; //Put c for this cell
//                            
//                            if(solve(board))
//                                return true; //If it's the solution return true
//                            else
//                                board[i][j] = '.'; //Otherwise go back
//                        }
//                    }
//                    
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//    
//    private boolean isValid(char[][] board, int row, int col, char c){
//        for(int i = 0; i < 9; i++) {
//            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
//            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
//            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
//board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
//        }
//        return true;
//    }
}