class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges){
        int n = edges.length;
        parent = new int[n+1];

        for(int i = 0 ; i <= n ; i++){
            parent[i] = i;
        }

        for(int[] ed : edges){
            int u = ed[0];
            int v = ed[1];
            int u_par = find(u);
            int v_par = find(v);

            if(u_par == v_par)
                return ed;
            parent[v_par] = u_par;
        }

        return null;
    }

    int find(int u){
        if(u == parent[u]){
            return u;
        }

        return parent[u] = find(parent[u]);
    }
}