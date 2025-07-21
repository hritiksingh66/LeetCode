class Solution {
    int[] parent;
    int[] rank; 
    public int makeConnected(int n, int[][] connections){
        int edges = connections.length;
         // n nodes ke liye min n-1 edges chahie hoga and if edges us sey kam ho to kabhi saare nodes ko apas me connect nahi kar payenge
        if( edges < (n-1)) return -1;

        parent = new int[n];

        for(int i = 0 ; i <n;i++){
            parent[i] = i;
        }

        rank = new int[n];
        // n --> starting me total n components the

        for(int[] ed : connections){
            int x = ed[0];
            int y = ed[1];

            if(find(x) != find(y)){
                union(x,y);
                n -= 1; // union karne pe components (ilaako) ka sankhya 1 se kam ho jayega na ji 
            }else{
                continue;
            }
        }

        return n - 1; // n components ko connect krne ke liye minimum n-1 edges to chahiye na guru
    }


    int find(int x){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    void union(int x , int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if(x_parent == y_parent){
            return;
        }
        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }else{
            parent[x_parent] = y_parent;
            rank[y_parent] += 1; 
        }
    }
}