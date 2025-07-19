class Solution {
    public int findCircleNum(int[][] isConnected){
        int V = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < V ; i++){
            for(int j = 0 ; j < V ; j++){
                if(isConnected[i][j] != 0 && j!=i){
                    adj.get(i).add(j);
                    adj.get(j).add(i);

                    isConnected[i][j] = 0;
                    isConnected[j][i] = 0;
                }
            }
        }

        boolean[] visited = new boolean[V];
        int res = 0;

        for(int i = 0 ; i < V;i++){
            if(!visited[i]){
                DFS(adj,i,visited);
                res++;
            }
        }
        return res;
    }

    public void DFS(List<List<Integer>> adj,int u,boolean[] visited){
        // Mark visited
        visited[u] = true;

        // call DFS for nbrs
        for(int v : adj.get(u)){
            if(!visited[v]){
                DFS(adj,v,visited);
            }
        }
    } 
}