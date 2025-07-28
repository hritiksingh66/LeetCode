class Solution {
    int targetOR;
    int[][] dp;
    public int countMaxOrSubsets(int[] nums) {
        targetOR = 0;
        for (int num : nums) {
            targetOR |= num;
        }
        dp = new int[nums.length][targetOR+1];
        for(int[] d:dp) Arrays.fill(d,-1);
        return backtrack(nums, 0, 0);

    }

    private int backtrack(int[] nums, int index, int currOR) {
        if (index == nums.length) {
            if (currOR == targetOR) {
                return 1;
            }
            return 0;
        }
        if(dp[index][currOR]!=-1) return dp[index][currOR];
        int t = backtrack(nums, index + 1, currOR | nums[index]);
        int not = backtrack(nums, index + 1, currOR);
        return dp[index][currOR] = t+not;
    }
}
