class Solution {
    class BipartitePair{
        int vtx;
        int dist;
        public BipartitePair(int vtx , int dist){
            this.vtx = vtx;
            this.dist = dist;
        }
    }
    
    public boolean isBipartite(int[][] graph){
        HashMap<Integer,Integer> visited = new HashMap<>();
        Queue<BipartitePair> q = new LinkedList<>();

        for(int src = 0 ; src < graph.length ; src++){
            if(visited.containsKey(src)){
                continue;
            }
            q.add(new BipartitePair(src,0));
            while(!q.isEmpty()){
                BipartitePair rv = q.poll();
                if(visited.containsKey(rv.vtx)){
                    if(visited.get(rv.vtx) != rv.dist){
                        return false;
                    }
                    continue;
                }
                visited.put(rv. vtx , rv.dist);
                for(int nbrs : graph[rv.vtx]){
                    if(!visited.containsKey(nbrs)){
                        BipartitePair newPair = new BipartitePair(nbrs , rv.dist + 1);
                        q.add(newPair);
                    }
                }
            }
        }
        return true;
    }
}