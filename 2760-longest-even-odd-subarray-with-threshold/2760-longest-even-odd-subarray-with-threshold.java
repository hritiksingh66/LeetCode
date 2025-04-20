class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int l = -1;  // Start index of current valid subarray
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > threshold || (i > 0 && l != -1 && nums[i] % 2 == nums[i - 1] % 2)) {
                if (l != -1) {
                    ans = Math.max(ans, i - l);
                }
                l = -1;
            }

            if (l == -1 && nums[i] % 2 == 0 && nums[i] <= threshold) {
                l = i;
            }
        }

        // Final check
        if (l != -1) {
            ans = Math.max(ans, nums.length - l);
        }

        return ans;
    }
}
