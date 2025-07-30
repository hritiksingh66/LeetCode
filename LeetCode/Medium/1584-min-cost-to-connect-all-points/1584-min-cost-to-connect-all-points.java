class Solution {
    int[] parent;
    int[] rank;


    public int minCostConnectPoints(int[][] points) {
        int V = points.length;

        parent = new int[V];
        for(int u = 0 ; u < V ; u++){
            parent[u] = u;
        }
        rank = new int[V];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);

        for(int u = 0 ; u < V-1 ; u++){
            int x1 = points[u][0];
            int y1 = points[u][1];

            for(int v = u+1 ; v < V ; v++){
                int x2 = points[v][0];
                int y2 = points[v][1];

                int dis = Math.abs(x2-x1) + Math.abs(y2 - y1);

                pq.add(new int[]{u,v,dis});
            }
        }

        return kruskal(pq);
    }

    int kruskal(PriorityQueue<int[]> pq){
        int res = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int u = curr[0];
            int v = curr[1];
            int w = curr[2];

            if(find(u) != find(v)){
                res += w;
                union(u,v);
            }
        }

        return res;
    }


    void union(int u, int v){
        int u_parent = find(u);
        int v_parent = find(v);

        if(u_parent == v_parent){
            return;
        }

        if(rank[u_parent] > rank[v_parent]){
            parent[v_parent] = u_parent;  
        }else if(rank[u_parent] < rank[v_parent]){
            parent[u_parent] = v_parent;  
        }else{
            parent[v_parent] = u_parent; 
            rank[u_parent] += 1; 
        }
    }

    int find(int u){
        if(u == parent[u]){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
}