class Solution {
    int m , n;
    int[][] dp;
    public int maximalSquare(char[][] matrix){
        m = matrix.length;
        n = matrix[0].length;

        dp = new int[m+1][n+1];

        for(int i = 0 ; i <= m ; i++){
            Arrays.fill(dp[i],-1);
        }
        
        int largestSquare = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    largestSquare = Math.max(largestSquare,solve(i, j, matrix));
                }
            }
        }

        int area = largestSquare * largestSquare;

        return area;
    }

    private int solve(int i, int j, char[][] matrix) {
        if (i >= m || j >= n || matrix[i][j] == '0') {
            return 0;
        }

        if(dp[i][i] != -1){
            return dp[i][j];
        }

        int right = solve(i, j + 1, matrix);
        int diag = solve(i + 1, j + 1, matrix);
        int down = solve(i + 1, j, matrix);

        return dp[i][j] = 1 + Math.min(right, Math.min(diag, down));
    }

}