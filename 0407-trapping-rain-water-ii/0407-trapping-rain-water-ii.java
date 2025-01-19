import java.util.PriorityQueue;

public class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Add all boundary cells to the priority queue
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        // Directions for moving up, down, left, and right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int waterTrapped = 0;

        // Process cells in the priority queue
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            for (int[] dir : directions) {
                int x = cell.row + dir[0];
                int y = cell.col + dir[1];

                // Skip if out of bounds or already visited
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                    continue;
                }

                // Calculate water trapped at the current cell
                waterTrapped += Math.max(0, cell.height - heightMap[x][y]);

                // Update height of the current cell and add it to the priority queue
                pq.offer(new Cell(x, y, Math.max(cell.height, heightMap[x][y])));
                visited[x][y] = true;
            }
        }

        return waterTrapped;
    }

    // Helper class to store cell information
    static class Cell {
        int row, col, height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}