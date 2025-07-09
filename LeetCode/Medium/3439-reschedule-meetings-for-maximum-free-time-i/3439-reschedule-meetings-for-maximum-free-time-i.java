class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        List<Integer> freeTime = new ArrayList<>();

        freeTime.add(startTime[0]); // incase if first event is not starting from zero

        for (int i = 1; i < n; i++) {
            freeTime.add(startTime[i] - endTime[i - 1]);

        }

        if (endTime[n - 1] < eventTime) { // incase if last event over before eventTime
            freeTime.add(eventTime - endTime[n - 1]);
        }

        // Sliding Window 
        int i = 0;
        int j = 0;
        int maxSum = 0;
        int currSum = 0;

        n = freeTime.size();
        while (j < n) {
            currSum += freeTime.get(j);
            if(i<n && j-i+1 > k+1) {
                currSum -= freeTime.get(i);
                i++;
            }
            maxSum = Math.max(maxSum,currSum);
            j++;
        }
        return maxSum;
    }
}