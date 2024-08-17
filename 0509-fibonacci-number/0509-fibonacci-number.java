class Solution {
    public int solve(int n , int[] dp){
        if( n <= 1){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = solve(n-1 , dp) + solve(n-2 , dp);
    }

    public int fib(int n) {
        if(n <= 1)  // Lowest possible value of param
            return n;

        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);    

        return solve(n , dp);
    }
}