class Solution {
    int n;
    int[][] t;

    public int solve(int l ,int r,String s){
        if(l == r){
            return 1;
        }
        if(l > r){
            return 0;
        }

        if(t[l][r] != -1){
            return t[l][r];
        }

        int i = l+1;

        while( i <= r && s.charAt(i)==s.charAt(l)){
            i++;
        }

        if(l == r+1){ // out of bound as all char are same
            return 1;
        }

        int basic = 1 + solve(i,r,s);

        // Greedy wala tarika
        int lalach = Integer.MAX_VALUE;

        for(int j=i; j <= r; j++){
            if(s.charAt(j) == s.charAt(l)){
                int ans = solve(i , j-1,s) + solve(j , r, s);
                lalach = Math.min(lalach , ans);
            }
        }

        return t[l][r] = Math.min(basic , lalach);
    }
    public int strangePrinter(String s) {
        n = s.length();

        t = new int[n][n+1];

        for(int[] row : t){
            Arrays.fill(row , -1);
        }
        return solve(0,n-1,s);
    }
}