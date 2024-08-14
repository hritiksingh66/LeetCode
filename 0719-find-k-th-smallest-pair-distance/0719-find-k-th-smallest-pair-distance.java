class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int largest = Integer.MIN_VALUE;
        for (int num : nums) {
            largest = Math.max(largest, num);
        }
        largest += 1;
        int[] temp = new int[largest];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                temp[Math.abs(nums[i] - nums[j])]++;
            }
        }

        for (int i = 0; i <= largest; i++) {
            k -= temp[i];
            if (k <= 0) {
                return i;
            }
        }

        return 0;

    }
}