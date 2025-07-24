class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        xor = new int[n];
        tree = new ArrayList[n];
        for(int i=0;i<n;i++)tree[i] = new ArrayList<>();
        for(int[] e : edges){
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);

        }
        dfs1(0,-1,nums);
        // System.out.println(Arrays.toString(xor));
        dfs2(0,new HashSet<>(),-1);
        return ans;

    }  
    int ans = (int)1e9;
    List<Integer> [] tree;  
    int[] xor ;   
    private  void dfs1(int x, int p,int[] nums){
        xor[x] = nums[x];
        for(int y : tree[x]){
            if(y!=p){
                dfs1(y,x,nums);
                xor[x] ^= xor[y];
            }
            
        }
    }
    private void dfs2(int x, Set<Integer> set, int p){
        set.add(x);
        dfs3(0,-1,set,x);
        for(int y : tree[x])
            if(y!=p)dfs2(y,set,x);
        set.remove(x);
    }
    private void dfs3(int x, int p, Set<Integer> ancestor,int a){
        if(x == a)return;
        int b,c;
        if(ancestor.contains(x)){
             b = xor[x] ^ xor[a];
             c = xor[0] ^ xor[x];
        }else{
            b = xor[x];
            c = xor[0] ^ xor[a] ^ b;
        }
        int curr = Math.max(xor[a],Math.max(b,c)) - Math.min(xor[a],Math.min(b,c));
        if(x!=0)ans = Math.min(ans,curr);
        // System.out.println(x+" "+a+" "+xor[a]+" "+b+" "+c);
        for(int y : tree[x])
            if(y!=p)dfs3(y,x,ancestor,a);
    }
}