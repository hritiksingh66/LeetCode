class Solution {
    int dfs(ArrayList<ArrayList<Integer>> l ,boolean[] vis,int u){
        vis[u] = true;
        int cnt = 1;
        for(int ne:l.get(u)){
            if(!vis[ne]) cnt += dfs(l,vis,ne);
        }
        return cnt;
    }

    public long countPairs(int n, int[][] edges){
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        for(int i=0;i<n;i++) l.add(new ArrayList<>());
        for(int[] e:edges){
            int u = e[0];
            int v = e[1];
            l.get(u).add(v);
            l.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        long res = 0;
        long remaining = n;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int size = dfs(l,vis,i);
                res += (long)size*(remaining - size);
                remaining -= size;
            }
        }
        return res;
    }
}