class Solution {
    void markGuarded(int  row, int col, int [][]grid){
        int m = grid.length;
        int n = grid[0].length;

        // Up
        for(int i = row-1 ; i>=0 ; i--){
            if(grid[i][col] == 2 || grid[i][col] == 3){
                break;
            }
            grid[i][col] = 1;
        }

        // Down
        for(int i = row+1 ; i < m ; i++){
            if(grid[i][col] == 2 || grid[i][col] == 3){
                break;
            }
            grid[i][col] = 1;
        }

        // Left
        for(int j = col - 1 ; j >=0 ; j--){
           if(grid[row][j] == 2 || grid[row][j] == 3){
                break;
            }
            grid[row][j] = 1;
        }

        // Right
        for(int j = col + 1 ; j < n ; j++){
           if(grid[row][j] == 2 || grid[row][j] == 3){
                break;
            }
            grid[row][j] = 1;
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int [][]grid = new int[m][n];

        // GRID me Saare Guard ke position ko mark kardenge 
        for(int []vec : guards){
            int i = vec[0];
            int j = vec[1];

            grid[i][j] = 2;
        }

        // GRID me Saare wall ke position ko mark kardenge 
        for(int []wall : walls){
            int i = wall[0];
            int j = wall[1];

            grid[i][j] = 3;
        }

        for(int []guard : guards){
            int i = guard[0];
            int j = guard[1];

            markGuarded(i , j , grid); // Saare Direction me check karo aur mark karo Guarded ya nahi
        }

        int result = 0 ;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] == 0)
                    result++;
            }
        }

        return result;

    }
}