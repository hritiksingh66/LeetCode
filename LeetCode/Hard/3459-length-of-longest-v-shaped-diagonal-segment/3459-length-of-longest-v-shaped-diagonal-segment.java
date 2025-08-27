class Solution {
    private int[][] dir = {{1,1},{1,-1},{-1,-1},{-1,1}};
    private int n , m; 
    public int lenOfVDiagonal(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        maxLength = Math.max(maxLength, 1 + dfs(grid, i, j, 2, d,true));
                    }
                }
            }
        }

        return maxLength;

    }

    private boolean isValid(int[][] grid, int i, int j, int expected){
        return i >= 0 && i < n && j >=0 && j < m && grid[i][j] == expected; 
    }

    private int dfs(int[][] grid, int i, int j, int expected, int d , boolean canTurn) {

        int newI = i + dir[d][0];
        int newJ = j + dir[d][1];


        if(!isValid(grid,newI,newJ,expected)){
            return 0;
        }

        int newExp = (expected == 2 )? 0 : 2;


        int maxLength = dfs(grid, newI, newJ, newExp, d ,canTurn);

        if(canTurn){
            int newDir = (d+1)%4;
            maxLength = Math.max(maxLength , dfs(grid,newI,newJ,newExp,newDir,false));
        }

        return maxLength + 1;
    }
}