class Solution {
    static Boolean[][] dp;
    public boolean canPartition(int[] nums){
        int n = nums.length;

        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum%2 != 0){
            return false;
        }

        sum = sum / 2;

        dp = new Boolean[n+1][sum+1];
        for(int i = 0 ; i < n+1 ; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i < sum +1 ; i++){
            dp[0][i] = false;
        }

        return solve(nums,sum, n);
    }

    boolean solve(int[] nums,int sum,int n){
        if(sum == 0){
            return true;
        }

        if(n==0){
            return false;
        }

        if(dp[n][sum] != null){
            return dp[n][sum];
        }

        if(nums[n-1] <= sum){
            return dp[n][sum] = solve(nums,sum-nums[n-1],n-1) || solve(nums,sum,n-1);
        }

        return dp[n][sum] = solve(nums,sum,n-1);
    }
}