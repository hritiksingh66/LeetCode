class Solution {
    int[] dp = new int[10001];

    public int solve(int n) {
        if(n == 0)
            return 0;

        if(dp[n] != -1){
            return dp[n];
        }

        int minCount = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) {
            int res = 1 + solve(n - (i * i));
            minCount = Math.min(res, minCount);
        }

        return dp[n] = minCount;
    }

    public int numSquares(int n) {
        Arrays.fill(dp,-1);
        return solve(n);
    }
}