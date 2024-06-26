class Solution {
    public double findMaxAverage(int[] nums, int k){
        int n = nums.length;

        double maxSum = 0;

        // Calculate the sum of the first k elements
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }

        double currentSum = maxSum;

        // Slide the window over the rest of the array
        for (int i = k; i < n; i++) {
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

       // Return the maximum average
        return maxSum / k;
    }
}