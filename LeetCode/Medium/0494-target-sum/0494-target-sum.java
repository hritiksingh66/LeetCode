class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int arrSum = 0;
        
        for (int num : nums) {
            arrSum += num;
        }

        if ((target + arrSum) % 2 != 0 || target > arrSum || (target + arrSum) < 0) {
            return 0;
        }

        int sum = (target + arrSum) / 2;

        return solve(nums,sum,n);
    }

    int solve(int[] nums,int sum, int n){
        // Base Case
        if(n == 0){
            if(sum==0) return 1;
            else return 0;
        }

        if(nums[n-1] <= sum){
            return solve(nums,sum-nums[n-1],n-1) + solve(nums,sum,n-1);
        }else{
            return solve(nums,sum,n-1);
        }
    }
}
