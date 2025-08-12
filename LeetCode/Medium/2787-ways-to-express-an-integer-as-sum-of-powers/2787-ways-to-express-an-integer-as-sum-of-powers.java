class Solution {
    int[][] dp;
    static final int M = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        int target = n;

        n = 0;

        while (Math.pow(n + 1, x) <= target) {
            n++;
        }
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.pow(i + 1, x);
        }

        dp = new int[n + 1][target + 1];

        for (int i = 0; i <= n ; i++) {
            dp[i][0] = 1;
        }

        return solve(arr, target, n);
    }

    private int solve(int[] arr, int target, int n) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = (int)(((long)dp[i - 1][j - arr[i - 1]] + dp[i - 1][j])%M);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }
}