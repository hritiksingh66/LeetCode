class Solution {
    static int[][] dp;

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(target) > sum) {
            return 0;
        }


        sum = (sum + target)/2;
        
        if (sum % 2 != 0) {
            return 0;
        }

        dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, sum, n);
    }

    int solve(int[] nums, int sum, int n) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }

        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }

        if (nums[n - 1] <= sum) {
            dp[n][sum] = solve(nums, sum-nums[n-1],n-1) + solve(nums,sum,n-1);
        }else{
            dp[n][sum] = solve(nums, sum, n - 1);
        }

        return dp[n][sum];

    }
}