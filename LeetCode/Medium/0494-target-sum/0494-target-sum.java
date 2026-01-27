class Solution {
    public int findTargetSumWays(int[] nums, int target){
        int n = nums.length;

        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        sum = sum + target;

        if(sum%2 != 0){
            return 0;
        }

        sum = sum/2;

        return solve(nums,sum,n);
    }

    int solve(int[] nums, int sum , int n){
        if(sum == 0 && n==0){
            return 1;
        }

        if(n == 0){
            return 0;
        }

        if(nums[n-1] <= sum){
            return solve(nums,sum-nums[n-1],n-1) + solve(nums,sum,n-1);
        }

        return solve(nums,sum,n-1);
    }
}