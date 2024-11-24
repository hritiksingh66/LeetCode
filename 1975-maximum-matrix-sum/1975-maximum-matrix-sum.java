class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length; 
        int n = matrix[0].length;

        int negativeCount = 0;
        int minAbsoluteValue = Integer.MAX_VALUE;
        long totalSum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                int absValue = Math.abs(value);

                totalSum += absValue;
                minAbsoluteValue = Math.min(minAbsoluteValue, absValue);

                if (value < 0) {
                    negativeCount++;
                }
            }
        }

        if (negativeCount % 2 != 0) {
            totalSum -= 2L * minAbsoluteValue;
        }

        return totalSum;
    }
}
