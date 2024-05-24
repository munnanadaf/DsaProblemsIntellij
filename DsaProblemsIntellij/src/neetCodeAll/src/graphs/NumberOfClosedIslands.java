package graphs;

// covered by 1 from all 4 directions. then closed island
class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int closedIslands = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                // if(i == 0 || i == m-1 || j == 0 || j==n-1)
                //     dfs(grid,i,j); // boundary is not closed.
                if(grid[i][j] == 0 && dfs(grid,i,j)){
                    closedIslands++;
                }

            }
        }
        return closedIslands;
    }

    public boolean dfs(int grid[][],int i , int j){
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length)
            return false; // on the boundary so obviosly not closed
        if(grid[i][j] == 1)
            return true; // not first time, for recursive cases it might become true for next dfs calls
        grid[i][j] = 1;
        boolean bottom = dfs(grid,i+1,j);
        boolean top = dfs(grid,i-1,j);
        boolean right = dfs(grid,i,j+1);
        boolean left = dfs(grid,i,j-1);
        return bottom && top && right && left; // if surrounded from all 4 directions.
    }
}