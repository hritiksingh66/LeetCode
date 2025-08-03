class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length; 
        int count = 0;

        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < cols ; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, rows, cols);
                    count++;
                }
            }
        }

        return count;        
    }

    void dfs(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '$';  

        int[][] pos = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};  

        for (int k = 0; k < 4; k++) {
            dfs(grid, i + pos[k][0], j + pos[k][1], rows, cols);
        }
    }
}
