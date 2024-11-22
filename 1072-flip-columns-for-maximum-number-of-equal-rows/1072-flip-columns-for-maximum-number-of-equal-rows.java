class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {

        Map<String, Integer> patternCount = new HashMap<>();
        int maxRows = 0;

        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();

            int base = row[0];

            for (int value : row) {
                pattern.append(value == base ? '1' : '0');
            }

            String patternStr = pattern.toString();
            patternCount.put(patternStr, patternCount.getOrDefault(patternStr, 0) + 1);

            maxRows = Math.max(maxRows, patternCount.get(patternStr));
        }

        return maxRows;
    }
}
