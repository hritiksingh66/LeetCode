class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree  = new int[V];

        for(int u = 0 ; u < V ; u++){
            for(int v : graph[u]){
                adj.get(v).add(u);
                indegree[u]++;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        
        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < V; i++){
            if(indegree[i] ==0){
                que.add(i);
                ans.add(i);
            }
        }


        while(!que.isEmpty()){
            int node = que.poll();

            for(int nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    ans.add(nbr);
                    que.add(nbr);
                }
            }

        }

        Collections.sort(ans);

        return ans;
    }
}