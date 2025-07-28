class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxOR = 0;
        int count = 0;

        int size = 1 << n;
        for (int num : nums) {
            maxOR |= num;
        }
        for (int mask = 1; mask < size; mask++) {
            int currOR = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    currOR |= nums[i];
                }
            }
            if (currOR == maxOR) {
                count++;
            }
        }

        return count;
    }
}