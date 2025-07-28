class Solution {
    int count = 0;
    int targetOR;
    public int countMaxOrSubsets(int[] nums) {
        targetOR = 0;
        for (int num : nums) {
            targetOR |= num;
        }
        backtrack(nums, 0, 0);

        return count;
    }

    private void backtrack(int[] nums, int index, int currOR) {
        if (index == nums.length) {
            if (currOR == targetOR) {
                count++;
            }
            return;
        }
        backtrack(nums, index + 1, currOR | nums[index]);
        backtrack(nums, index + 1, currOR);
    }
}
