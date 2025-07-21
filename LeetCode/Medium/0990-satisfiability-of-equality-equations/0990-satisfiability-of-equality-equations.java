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
            char frstChar = str.charAt(0);
            char secChar = str.charAt(3);
            if(str.charAt(1)=='='){
                union(frstChar,secChar);
            }
        }

        for(String str : equations){
            char frstChar = str.charAt(0);
            char secChar = str.charAt(3);
            if(str.charAt(1)=='!'){
                int first_idx = frstChar - 'a'; 
                int sec_idx = secChar - 'a'; 
                if(find(first_idx) == find(sec_idx)){
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

    public void union(char a, char b){
        int idx_a = a - 'a';
        int idx_b = b - 'a';

        int parent_a = find(idx_a);
        int parent_b = find(idx_b);

        if(parent_a == parent_b){
            return;
        }

        if(rank[parent_a] > rank[parent_b]){
            parent[parent_b] = parent_a;
        }else if(rank[parent_a] < rank[parent_b]){
            parent[parent_a] = parent_b;
        }else{
            parent[parent_a] = parent_b;
            rank[parent_b] += 1;
        }
    }
}