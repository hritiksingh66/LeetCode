class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int leftMost = n; // for leftmost column position
        int rightMost = -1; // for rightMost column Position
        int topMost = m; // for topMost row position
        int bottomMost = -1; // for bottomMost row Position

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    leftMost = Math.min(leftMost, col);
                    rightMost = Math.max(rightMost, col);
                    topMost = Math.min(topMost, row);
                    bottomMost = Math.max(bottomMost, row);
                }
            }
        }

        int length = rightMost - leftMost + 1;
        int breadth = bottomMost - topMost + 1;

        int area = length * breadth;

        return area;

    }
}