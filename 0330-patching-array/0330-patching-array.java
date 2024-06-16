public class Solution {
    public int minPatches(int[] nums, int n) {
        long missing = 1; // The smallest number that we can't form
        int i = 0; // Index to iterate over nums
        int patches = 0; // Number of patches added

        while (missing <= n) {
            if (i < nums.length && nums[i] <= missing) {
                // If the current number in nums can contribute to forming the missing number
                missing += nums[i];
                i++;
            } else {
                // If the current number in nums is too large to contribute, add the missing number as a patch
                missing += missing;
                patches++;
            }
        }

        return patches;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 3};
        int n1 = 6;
        System.out.println(sol.minPatches(nums1, n1)); // Output: 1

        int[] nums2 = {1, 5, 10};
        int n2 = 20;
        System.out.println(sol.minPatches(nums2, n2)); // Output: 2

        int[] nums3 = {1, 2, 2};
        int n3 = 5;
        System.out.println(sol.minPatches(nums3, n3)); // Output: 0
    }
}
