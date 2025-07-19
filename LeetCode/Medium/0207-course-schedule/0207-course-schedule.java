class Solution{
   public boolean DFS(List<List<Integer>> adj,int u,boolean[] visited,boolean[] inRecurs){
        visited[u] = true;
        inRecurs[u] = true;
        
        for(int nbr : adj.get(u)){
            // if not visited,then we check for cycle in DFS
            if(!visited[nbr] && DFS(adj,nbr,visited,inRecurs)){
                return true;
            }else if(inRecurs[nbr]){
                return true;
            }
        }
        
        inRecurs[u] = false;
        
        return false;
    }

    public boolean canFinish(int V, int[][] prerequisites){
        // if(prerequisites.length == 0) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] vec : prerequisites){
            int u = vec[0];
            int v = vec[1];

            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        boolean[] inRecurs = new boolean[V];

        for(int i = 0 ; i < V ; i++){
            if(!visited[i] && DFS(adj,i,visited,inRecurs)){
                return false;
            }
        }

        return true;
    }
}