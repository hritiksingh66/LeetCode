class Solution {
    public int maxValue(int[][] events, int k) {
        // Sort by start time
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int n = events.length;

        // Preprocess: store next index for each event (first event with start > current end)
        int[] nextIndex = new int[n];
        for (int i = 0; i < n; i++) {
            int lo = i + 1, hi = n;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (events[mid][0] > events[i][1]) hi = mid;
                else lo = mid + 1;
            }
            nextIndex[i] = lo;
        }

        Integer[][] dp = new Integer[n][k + 1];
        return dfs(0, k, events, nextIndex, dp);
    }

    private int dfs(int i, int k, int[][] events, int[] nextIndex, Integer[][] dp) {
        if (i == events.length || k == 0) return 0;
        if (dp[i][k] != null) return dp[i][k];

        // Skip current event
        int skip = dfs(i + 1, k, events, nextIndex, dp);

        // Attend current event and go to the next non-overlapping
        int take = events[i][2] + dfs(nextIndex[i], k - 1, events, nextIndex, dp);

        return dp[i][k] = Math.max(skip, take);
    }
}
