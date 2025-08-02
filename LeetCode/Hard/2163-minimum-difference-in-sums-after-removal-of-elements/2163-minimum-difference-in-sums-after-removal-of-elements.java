class Solution {
    public long minimumDifference(int[] nums) {
        int N = nums.length;
        int n = N / 3;

        // ---------- Left Min Sum ----------
        long[] leftMinSum = new long[N];
        PriorityQueue<Integer> leftPq = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap

        long leftSum = 0;
        for (int i = 0; i < 2 * n; i++) {
            leftPq.add(nums[i]);
            leftSum += nums[i];

            if (leftPq.size() > n) {
                leftSum -= leftPq.poll();
            }

            if (i >= n - 1) {
                leftMinSum[i] = leftSum;
            }
        }

        // ---------- Right Max Sum ----------
        long[] rightMaxSum = new long[N];
        PriorityQueue<Integer> rightPq = new PriorityQueue<>(); // Min-heap

        long rightSum = 0;
        for (int i = N - 1; i >= n; i--) {
            rightPq.add(nums[i]);
            rightSum += nums[i];

            if (rightPq.size() > n) {
                rightSum -= rightPq.poll();
            }

            if (i <= 2 * n) {
                rightMaxSum[i] = rightSum;
            }
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