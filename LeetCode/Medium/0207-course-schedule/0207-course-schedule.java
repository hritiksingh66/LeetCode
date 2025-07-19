class Solution {
    public boolean canFinish(int V, int[][] prerequisites){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }
        // Indegree
        int[] indegree = new int[V];

        for(int[] vec : prerequisites){
            int u = vec[0];
            int v = vec[1];

            adj.get(v).add(u);
            indegree[u]++;
        }

        int count = 0;

        Queue<Integer> que = new LinkedList<>();
        // Fill the queue with 0 indegree
        for(int u = 0 ; u < V; u++){
            if(indegree[u] == 0){
                que.add(u);
                count++;
            }
        }

        while(!que.isEmpty()){
            int u = que.poll();

            for(int v : adj.get(u)){
                indegree[v]--;

                if(indegree[v] == 0){
                    count++;
                    que.add(v);
                }
            }
        }
        
        if(count == V) return true;
        return false;
    }
}