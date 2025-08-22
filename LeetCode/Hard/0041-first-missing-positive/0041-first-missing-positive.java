class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int crktIdx = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[crktIdx];
                nums[crktIdx] = temp;
            }
        }

        int i = 1;

        for (int num : nums) {
            if (num != i) {
                return i;
            }
            i++;
        }

        return n + 1;

    }
}