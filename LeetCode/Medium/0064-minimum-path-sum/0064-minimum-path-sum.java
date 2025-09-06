class Solution {
    int m , n;
    int[][] dp;
    public int minPathSum(int[][] grid){
        m = grid.length;
        n = grid[0].length;
        dp = new int[m+1][n+1];

        for(int i = 0 ; i <= m ; i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(grid,0,0);
    }

    private int solve(int[][] grid,int r,int c){
        if(r == m - 1 && c == n - 1){
            return grid[r][c];
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }

        int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;

        // agar right jaa sakte hai
        if (c + 1 < n) {
            right = solve(grid, r, c + 1);
        }

        // agar neeche jaa sakte hai
        if (r + 1 < m) {
            down = solve(grid, r + 1, c);
        }

        // ab current cell ka result = grid[r][c] + min(right, down)
        return dp[r][c] = grid[r][c] + Math.min(right, down);
    }
}