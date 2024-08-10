class Solution {
    private int[] parent;
    private int[] rank;
    private int regions;

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int totalCells = n * n * 4; // each cell divided into 4 parts
        parent = new int[totalCells];
        rank = new int[totalCells];
        regions = totalCells;

        // Initialize Union-Find structure
        for (int i = 0; i < totalCells; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = (i * n + j) * 4;
                char ch = grid[i].charAt(j);

                // Union triangles within the cell
                if (ch == '/') {
                    union(index + 0, index + 3); // 0-3
                    union(index + 1, index + 2); // 1-2
                } else if (ch == '\\') {
                    union(index + 0, index + 1); // 0-1
                    union(index + 2, index + 3); // 2-3
                } else {
                    union(index + 0, index + 1); // All parts together
                    union(index + 1, index + 2);
                    union(index + 2, index + 3);
                }

                // Union with adjacent cells
                if (i > 0) { // Top cell
                    union(index + 0, ((i - 1) * n + j) * 4 + 2);
                }
                if (j > 0) { // Left cell
                    union(index + 3, (i * n + (j - 1)) * 4 + 1);
                }
            }
        }

        return regions;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // Path compression
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            regions--;
        }
    }
}
