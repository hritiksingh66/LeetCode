class Solution {
    public int numTilings(int n) {
        long[] dp = new long[4];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 5;
        int cur = n - 1;
        for (int i = 3; i < n; i++) {
            cur = i % 4;
            dp[cur] = (2 * dp[(cur + 3) % 4] + dp[(cur + 1) % 4]) % 1000000007;
        }
        return (int)dp[cur];
    }
}