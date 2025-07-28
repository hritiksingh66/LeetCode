class Solution {
    int primsAlgo(List<List<Pair>> adj, int V){
        boolean[] inMST = new boolean[V];
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);
        pq.add(new Edge(0,0));
        
        int sum = 0;
        while(!pq.isEmpty()){
            Edge curr = pq.poll();

            if(inMST[curr.node]) continue;

            inMST[curr.node] = true;
            sum += curr.wt;
            
            for(Pair nbr : adj.get(curr.node)){
                if(!inMST[nbr.node]){
                    pq.add(new Edge(nbr.wt,nbr.node));
                }
            }
        }

        return sum;

    }
    public int minCostConnectPoints(int[][] edge) {
        int V = edge.length;

        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < V; i++){
            for(int j = i+1; j < V; j++){
                int x1 = edge[i][0];
                int y1 = edge[i][1];
                int x2 = edge[j][0];
                int y2 = edge[j][1];

                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);

                adj.get(i).add(new Pair(j,dist));
                adj.get(j).add(new Pair(i,dist));
            }
        }

        return primsAlgo(adj,V);   
    }

    static class Pair{
        int node;
        int wt;
        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }

    static class Edge{
        int wt,node;
        Edge(int wt, int node){
            this.wt = wt;
            this.node = node;
        }
    }
}