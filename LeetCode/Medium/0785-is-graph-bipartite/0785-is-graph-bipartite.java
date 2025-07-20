class Solution {
    public boolean isBipartiteBFS(int[][] adj,int u,int[] color,int currColor){
        Queue<Integer> que = new LinkedList<>();
        que.add(u);

        color[u] = currColor;

        while(!que.isEmpty()){
            int currNode = que.poll();

            for(int nbr : adj[currNode]){
                if(color[nbr] == color[currNode]){
                    return false;
                }else if(color[nbr] == -1){ // never colored(visited)
                    color[nbr] = 1-color[currNode];
                    que.add(nbr);
                }
            }
            
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;

        int[] color = new int[V];

        Arrays.fill(color, -1); // Initially no node is colored

        // Red = 1 , green = 0

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!isBipartiteBFS(graph, i, color, 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}