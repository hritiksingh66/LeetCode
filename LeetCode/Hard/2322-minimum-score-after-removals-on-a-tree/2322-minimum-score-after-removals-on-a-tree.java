class Solution {
    int[] inTime;
    int[] outTime;
    int[] subtreeXOR;
    List<List<Integer>> adj;
    int timer = 0; 

    public int minimumScore(int[] nums, int[][] edges) {
        int V = nums.length;

        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        subtreeXOR = new int[V];
        inTime = new int[V];
        outTime = new int[V];

        // Call DFS with root 0 and parent -1
        DFS(0, -1, nums);

        int res = Integer.MAX_VALUE;

        for (int u = 1; u < V - 1; u++) {
            for (int v = u + 1; v < V; v++) {
                int xor1, xor2, xor3;

                if (isAncestor(u, v)) {
                    xor1 = subtreeXOR[v];
                    xor2 = subtreeXOR[u] ^ subtreeXOR[v];
                } else if (isAncestor(v, u)) {
                    xor1 = subtreeXOR[u];
                    xor2 = subtreeXOR[v] ^ subtreeXOR[u];
                } else {
                    xor1 = subtreeXOR[u];
                    xor2 = subtreeXOR[v];
                }

                xor3 = subtreeXOR[0] ^ xor1 ^ xor2;
                res = Math.min(res, getScore(xor1, xor2, xor3));
            }
        }

        return res;
    }

    public int getScore(int a, int b, int c) {
        int largest = Math.max(a, Math.max(b, c));
        int smallest = Math.min(a, Math.min(b, c));
        return largest - smallest;
    }

    public boolean isAncestor(int u, int v) {
        return inTime[v] >= inTime[u] && outTime[u] >= outTime[v];
    }

    public void DFS(int node, int parent, int[] nums) {
        inTime[node] = timer++;
        subtreeXOR[node] = nums[node];

        for (int nbr : adj.get(node)) {
            if (nbr != parent) {
                DFS(nbr, node, nums);
                subtreeXOR[node] ^= subtreeXOR[nbr];
            }
        }

        outTime[node] = timer++;
    }
}
