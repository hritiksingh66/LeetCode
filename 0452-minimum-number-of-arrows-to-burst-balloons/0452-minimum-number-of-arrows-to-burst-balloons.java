class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0])); // Sort based on start points
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > arrowPos) {
                arrowCnt++;
                arrowPos = points[i][1];
            } else {
                // Update arrowPos to the minimum of current arrowPos and points[i][1]
                arrowPos = Math.min(arrowPos, points[i][1]);
            }
        }
        return arrowCnt;
    }
}