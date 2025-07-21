class Solution {
    int[] parent;
    int[] rank;

    int find(int x){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    void union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if(x_parent == y_parent){
            return;
        }

        if(rank[x_parent] > rank[y_parent]){
            parent[x_parent] = y_parent;
        }else if(rank[x_parent] < rank[y_parent]){
            parent[y_parent] = x_parent;
        }else{
            parent[y_parent] = x_parent;
            rank[x_parent] += 1;
        }
    }

    public long countPairs(int n, int[][] edges){
        parent = new int[n];
        for(int i = 0 ; i < n; i++){
            parent[i] = i;
        }

        rank = new int[n];


        for(int[] edge: edges){
            int x = edge[0];
            int y = edge[1];

            if(find(x) != find(y)){
                union(x,y);
            }else{
                continue;
            }
        }

        Map<Integer,Integer> mp = new HashMap<>();

        for(int i = 0 ; i < n;i++){
            mp.put(find(i),mp.getOrDefault(find(i),0)+1);
        }

        long res = 0;

        long remaining = n;

        for(int size : mp.values()){
            res += (long)size*(remaining - size);
            remaining -= size;
        }
        return res;
    }
}