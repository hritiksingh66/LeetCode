class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> qu = new LinkedList<>();

        qu.add(new int[] { entrance[0], entrance[1] });

        maze[entrance[0]][entrance[1]] = '+';

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int level = 0;

        while (!qu.isEmpty()) {
            int size = qu.size();

            while (size-- > 0) {
                int[] pair = qu.poll();
                int i = pair[0];
                int j = pair[1];

                if (!(i == entrance[0] && j == entrance[1]) && (i == 0 || j == 0 || i == m - 1 || j == n - 1)) {
                    return level;
                }

                // Explore nbrs

                for (int[] d : dir) {
                    int new_i = i + d[0];
                    int new_j = j + d[1];

                    if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && maze[new_i][new_j] == '.') {
                        qu.add(new int[] { new_i, new_j });
                        maze[new_i][new_j] = '+';
                    }
                }

            }

            level++;
        }

        return -1;
    }
}