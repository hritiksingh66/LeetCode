class Solution {
    public int findMinDifference(List<String> timePoints){
        int n = timePoints.size();

        int[] totalMinutes = new int[n];

        for(int i = 0 ; i < n; i++){
            String str = timePoints.get(i);

            int hours = Integer.parseInt(str.substring(0,2));
            int minutes = Integer.parseInt(str.substring(3));

            totalMinutes[i] = hours * 60 + minutes;
        }

        Arrays.sort(totalMinutes);

        int ans = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++){
            ans = Math.min(ans ,(totalMinutes[i] - totalMinutes[i-1]));
        }

        return Math.min(ans , (24*60 - totalMinutes[n-1]) + totalMinutes[0]);
    }
}