package matrix;

import java.util.HashMap;
import java.util.Map;

class DifferenceMatrix {
	
	// BRUTEFORCE
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] diff = new int[m][n];


        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                int[] values = countZeroes(grid,i,j);
                diff[i][j] = values[1]-values[0];
            }
        }
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                int[] values = countZeroes(grid,i,j);
                diff[i][j] = values[1]-values[0];
            }
        }

        return diff;

    }

    public int[] countZeroes(int grid[][],int row,int col){
        int onesZeroes[] = new int[2];
        for(int i = 0;i<grid.length;i++){
            if(grid[i][col] == 0)
                onesZeroes[0]++;
        }
        for(int i = 0;i<grid[0].length;i++){
            if(grid[row][i] == 0)
                onesZeroes[0]++;
        }

        for(int i = 0;i<grid.length;i++){
            if(grid[i][col] == 1)
                onesZeroes[1]++;
        }

        for(int i = 0;i<grid[0].length;i++){
            if(grid[row][i] == 1)
                onesZeroes[1]++;
        }
        return onesZeroes;
    }
	
	// optimal

	public static int[][] onesMinusZeros1(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] diff = new int[m][n];
		Map<Integer, Integer> rowZeroes = new HashMap<>();
		Map<Integer, Integer> colZeroes = new HashMap<>();
		Map<Integer, Integer> rowOnes = new HashMap<>();
		Map<Integer, Integer> colOnes = new HashMap<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					rowZeroes.put(i, rowZeroes.getOrDefault(i, 0) + 1);
					colZeroes.put(j, colZeroes.getOrDefault(j, 0) + 1);
				} else {
					rowOnes.put(i, rowOnes.getOrDefault(i, 0) + 1);
					colOnes.put(j, colOnes.getOrDefault(j, 0) + 1);
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				int ones = 0;
				int zeroes = 0;
				if (rowOnes.get(i) != null)
					ones += rowOnes.get(i);
				if (colOnes.get(j) != null)
					ones += colOnes.get(j);
				if (rowZeroes.get(i) != null)
					zeroes += rowZeroes.get(i);
				if (colZeroes.get(j) != null)
					zeroes += colZeroes.get(j);
				diff[i][j] = ones - zeroes;
			}
		}

		return diff;

	}

	public static void main(String[] args) {
		int a[][] = { { 0, 1, 1 }, { 1, 0, 1 }, { 0, 0, 1 } };
		int res[][] = onesMinusZeros1(a);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}