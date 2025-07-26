class Solution {
    public int networkDelayTime(int[][] times, int n, int k){
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];

            adj.get(u).add(new Pair(v,time));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.node - b.node);

        
        int[] res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[k] = 0;

        pq.add(new Pair(0,k));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u_time = curr.node;
            int u = curr.time;

            if (u_time > res[u]) continue;

            for(Pair nbr : adj.get(u)){
                int nbr_node = nbr.node;
                int nbr_time = nbr.time;

                if(u_time + nbr_time < res[nbr_node]){
                    res[nbr_node] = u_time + nbr_time;
                    pq.add(new Pair(res[nbr_node],nbr_node));
                }

            } 
        }

        int maxAns = 0;

        for(int i = 1; i < res.length;i++){
            if(res[i] == Integer.MAX_VALUE) return -1;
            maxAns = Math.max(maxAns,res[i]);
        }


        return maxAns;
    }
}

class Pair{
    int node;
    int time;
    Pair(int node, int time){
        this.node = node;
        this.time = time;
    }
}