class Solution {
    public long minimumDifference(int[] nums) {
        int N = nums.length;
        int n = N / 3;

        long[] leftMinSum = new long[N];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 

        long leftSum = 0;
        for (int i = 0; i < 2 * n; i++) {
            maxHeap.add(nums[i]);
            leftSum += nums[i];

            if (maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }

            leftMinSum[i] = leftSum;
        }

        long[] rightMaxSum = new long[N];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min-heap

        long rightSum = 0;
        for (int i = N - 1; i >= n; i--) {
            minHeap.add(nums[i]);
            rightSum += nums[i];

            if (minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }
            
            rightMaxSum[i] = rightSum;
        }

        // ---------- Find Minimum Difference ----------
        long ans = Long.MAX_VALUE;

        for (int i = n - 1; i < 2 * n; i++) {
            long diff = leftMinSum[i] - rightMaxSum[i + 1];
            ans = Math.min(ans, diff);
        }

        return ans;
    }
}