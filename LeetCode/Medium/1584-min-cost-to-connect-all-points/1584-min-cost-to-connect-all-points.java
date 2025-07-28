class Solution {

    public int minCostConnectPoints(int[][] points) {
        int V = points.length;

        boolean[] inMST = new boolean[V];
        int[] minDist = new int[V];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(0, 0));

        int cost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int wt = curr.wt;

            if (inMST[u])
                continue;

            inMST[u] = true;
            cost += wt;

            for (int v = 0; v < V; v++) {
                if (!inMST[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    if (dist < minDist[v]) {
                        minDist[v] = dist;
                        pq.add(new Pair(v, dist));
                    }
                }
            }
        }

        return cost;
    }

    static class Pair {
        int node, wt;

        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }
}
