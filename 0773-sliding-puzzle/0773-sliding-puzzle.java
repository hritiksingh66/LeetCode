import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450"; // Correct target state
        StringBuilder str = new StringBuilder();
        int r = 2, c = 3;

        // Convert the board to a string
        for (int[] row : board) {
            for (int col : row) {
                str.append(col);
            }
        }

        int[][] dir = {
            {1, 3},       // Possible moves for index 0
            {0, 2, 4},    // Possible moves for index 1
            {1, 5},       // Possible moves for index 2
            {0, 4},       // Possible moves for index 3
            {1, 3, 5},    // Possible moves for index 4
            {2, 4}        // Possible moves for index 5
        };

        // BFS setup
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.offer(str.toString());
        vis.add(str.toString());

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) { // Ensure full processing of all nodes at this level
                String cur = q.poll();
                if (cur.equals(target)) {
                    return moves; // Solution found
                }

                // Find the index of '0'
                int zIdx = cur.indexOf('0');

                // Try all possible swaps
                for (int next : dir[zIdx]) {
                    String nextState = swap(cur, zIdx, next);
                    if (!vis.contains(nextState)) {
                        q.offer(nextState);
                        vis.add(nextState);
                    }
                }
            }
            moves++;
        }

        return -1; // Solution not found
    }

    private String swap(String st, int i, int j) {
        char[] s = st.toCharArray();
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        return new String(s);
    }
}