class Solution {
    // private final int[][] directions = {{-1, 0}}

    private int m;
    private int n;

    private void dfs(int[][] grid, int i, int j, boolean[][] vis){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] || grid[i][j] == 0){
            return;
        }

        vis[i][j] = true; //mark visited

        dfs(grid, i+1, j, vis);
        dfs(grid, i-1, j, vis);
        dfs(grid, i, j+1, vis);
        dfs(grid, i, j-1, vis);

    }
    int numberOfIslandsUtil(int[][] grid){
        boolean[][] vis = new boolean[m][n];
        int islands = 0;


        for(int i = 0 ; i < m; i++){
            for(int j=0; j < n ; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    dfs(grid, i , j, vis);
                    islands++;
                }
            }
        }

        return islands;
    }

    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int isLands = numberOfIslandsUtil(grid);
        if(isLands > 1 || isLands == 0){
            return 0;
        }else{ // we have only one island
            // check if we can disconnect the grid in one day

            for(int i = 0 ; i < m ; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 1){
                        grid[i][j] = 0; //convert to water

                        isLands = numberOfIslandsUtil(grid);

                        if(isLands > 1 || isLands == 0){
                            return 1;
                        }

                        grid[i][j] = 1; // Make it Land again and now go to try for next cell
                    }

                }
            }

        }
        return 2;
    }
}