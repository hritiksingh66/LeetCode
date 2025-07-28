class Solution {
    int[] parent;
    int[] rank;
    public int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public void union(int u, int v){
        int u_par = find(u);
        int v_par = find(v);

        if(u_par == v_par){
            return;
        }

        if(rank[u_par] > rank[v_par]){
            parent[v_par] = u_par; 
        }else if(rank[u_par] < rank[v_par]){
            parent[u_par] = v_par; 
        }else{
            parent[v_par] = u_par;
            rank[v_par] += 1;
        }

    }
    public boolean validPath(int n, int[][] edges, int src, int des){
        parent = new int[n];
        rank = new int[n];

        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        for(int[] e:edges){
            int u = e[0];
            int v = e[1];
            if(find(u)== find(v)) continue;
            union(u,v);
        }
        return find(src) == find(des);
    }

}