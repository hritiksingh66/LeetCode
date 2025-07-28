class Solution {
    public boolean validPath(int n, int[][] edges, int src, int des){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] ed : edges){
            int u = ed[0];
            int v = ed[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        boolean[] vis = new boolean[n];

        return dfs(src,adj,vis,des);
    }

    private boolean dfs(int node,List<List<Integer>> adj,boolean[] vis,int des){
        //Mark visited
        vis[node] = true;

        if(node == des) return true;

        for(int nbr : adj.get(node)){
            if(!vis[nbr]){
               return dfs(nbr,adj,vis,des);
            }
        }
        return false;
    }
}