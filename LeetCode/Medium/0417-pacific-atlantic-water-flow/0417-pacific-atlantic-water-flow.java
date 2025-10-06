class Solution {
    private final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return result;

        int m = heights.length, n = heights[0].length;
        int[][] vis = new int[m][n]; 

        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();

        for (int i = 0; i < m; i++) pacific.offer(new int[]{i, 0});
        for (int j = 0; j < n; j++) pacific.offer(new int[]{0, j});

        for (int i = 0; i < m; i++) atlantic.offer(new int[]{i, n - 1});
        for (int j = 0; j < n; j++) atlantic.offer(new int[]{m - 1, j});

        bfs(heights, pacific, vis, 1); 
        bfs(heights, atlantic, vis, 2); 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 3) { 
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, int[][] vis, int mark) {
        int m = heights.length, n = heights[0].length;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];

            if ((vis[i][j] & mark) == mark) continue; 
            vis[i][j] += mark;

            for (int[] dir : directions) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni < 0 || ni >= m || nj < 0 || nj >= n) continue;
                if (heights[ni][nj] < heights[i][j]) continue; 
                queue.offer(new int[]{ni, nj});
            }
        }
    }
}
