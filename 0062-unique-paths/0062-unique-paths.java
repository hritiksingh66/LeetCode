class Solution {
     int[][] t;
    public int solve(int row , int col , int m , int n){
        if(row >= m || col >= n)
            return 0;
        

        if(row == m-1 && col == n-1)
            return 1;
        

        if(t[row][col] != -1) 
            return t[row][col];

        return t[row][col] = solve(row , col+1, m , n) + solve(row+1 , col, m , n);
    }
    public int uniquePaths(int m, int n){
        t = new int[m][n];

        for (int[] row: t)
            Arrays.fill(row, -1);

        return solve(0,0,m,n);
    }
}