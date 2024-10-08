class Solution {

    // Find count of pairs having distance <= D
    private int slidingWindowCount(int[] nums, int D) {
        int count = 0;
        int n = nums.length;
        int i = 0;
        int j = 1;

        while (j < n) {
            while (nums[j] - nums[i] > D) {
                i++;
            }
            count += j - i;
            j++;
        }
        return count;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = nums[n - 1] - nums[0];
        int result = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            int count = slidingWindowCount(nums, mid);

            if (count < k) {
                l = mid + 1;
            } else {
                result = mid; // Store the mid as a potential result
                r = mid - 1;
            }
        }
        return result;
    }
}