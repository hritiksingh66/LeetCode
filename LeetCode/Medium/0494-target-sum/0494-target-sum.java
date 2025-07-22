class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return rec(nums,target,0);
    }
    public static int rec(int[] nums,int target,int i){
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }
        int take1 = rec(nums, target - nums[i], i + 1);
        int take2 = rec(nums, target + nums[i], i + 1);
        return take1 + take2;
    }
}