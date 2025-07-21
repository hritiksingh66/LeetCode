class Solution {
    int[] parent; 
    int[] rank;

    public boolean equationsPossible(String[] equations){
        rank = new int[26];
        parent = new int[26];
        for(int i = 0 ; i < 26;i++){
            parent[i] = i;
        }


        for(String str : equations){
            if(str.charAt(1)=='='){
                int x = str.charAt(0)-'a';
                int y = str.charAt(3)-'a';
                union(x,y);
            }
        }

        for(String str : equations){
            if(str.charAt(1)=='!'){
                int x = str.charAt(0)-'a';
                int y = str.charAt(3)-'a';
                if(find(x) == find(y)){
                    return false;
                }
            }
        }


        return true;        
    }

    public int find(int idx){
        if(idx == parent[idx]){
            return idx;
        }

        return parent[idx] = find(parent[idx]);
    }

    public void union(int x, int y){
        int parent_x = find(x);
        int parent_y = find(y);

        if(parent_x == parent_y){
            return;
        }

        if(rank[parent_x] > rank[parent_y]){
            parent[parent_y] = parent_x;
        }else if(rank[parent_x] < rank[parent_y]){
            parent[parent_x] = parent_y;
        }else{
            parent[parent_x] = parent_y;
            rank[parent_y] += 1;
        }
    }
}