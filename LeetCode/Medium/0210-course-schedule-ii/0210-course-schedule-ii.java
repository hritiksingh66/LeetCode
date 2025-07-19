class Solution {
    boolean hasCycle = false;
    public void DFS(List<List<Integer>> adj, int u, boolean[] visited, boolean[] inRecurs,Stack<Integer> st) {
        visited[u] = true;
        inRecurs[u] = true;

        for (int nbr : adj.get(u)){
            // If already in RecurS means it has cycle
            if(inRecurs[nbr]) {
                hasCycle = true;
                return;
            }
            // if not visited,then we check for cycle in DFS
            if (!visited[nbr]) {
                DFS(adj,nbr,visited,inRecurs,st);
            } 
        }

        st.push(u);
        inRecurs[u] = false;
    }

    public int[] findOrder(int V, int[][] edges) {
        // Make adjacency List
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];
        boolean[] inRecurs = new boolean[V];

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < V;i++){
            if(!visited[i]){
                DFS(adj,i,visited,inRecurs,st);
                if(hasCycle) return new int[0];
            }
        }

        int[] res = new int[V];
        for(int i=0;i<V;i++){
            res[i] = st.pop();
        }
        return res;
    }
}