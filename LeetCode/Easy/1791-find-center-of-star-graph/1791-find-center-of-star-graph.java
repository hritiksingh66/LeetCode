class Solution {
    public int findCenter(int[][] edges){
        int V = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        int[] inorder = new int[V+1];

        for(int i = 0 ; i <= V ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            inorder[v]++;
            adj.get(v).add(u);
            inorder[u]++;
        }


        for(int i = 0 ; i <= V;i++) {
            if(inorder[i] == V-1){
                return i;
            }
        }

        return -1;
   
    }
}