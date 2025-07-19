class Solution {
    public int[] findOrder(int V, int[][] edges){

        // Make adjacency List
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
            indegree[u]++;
        }

        //Fill the que with node having 0 indegree
        Queue<Integer> que = new LinkedList<>();
        int count = 0;
        for(int u = 0 ; u < V ; u++){
            if(indegree[u] == 0){
                que.add(u);
                count++;
            }
        }

        int[] res = new int[V];

        // simple BFS
        int pos = 0;

        while(!que.isEmpty()){
            int u = que.poll();
            res[pos++] = u;

            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    que.add(v);
                    count++;
                }
            }
        }

        if(count < V) return new int[0];

        return res;
    }
}