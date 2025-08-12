class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfWays(int n, int x) {
        int target = n;

        n = 1;
        while (Math.pow(n, x) <= target) {
            n++;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.pow(i + 1, x);
        }

        int[] dp = new int[target + 1];
        dp[0] = 1; 

        for (int num : arr) {
            for (int sum = target; sum >= num; sum--) {
                dp[sum] = (dp[sum] + dp[sum - num]) % MOD;
            }
        }

        return dp[target];
    }
}
