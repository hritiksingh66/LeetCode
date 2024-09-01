class Solution {
    public int[][] construct2DArray(int[] original, int m, int n){
        int l = original.length;

        if(l != (m*n)){
            return new int[0][0];
        }

        int pos = 0;

        int[][] ans = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0;j < n ; j++){
                if( pos < l && l == (m*n)){
                    ans[i][j] = original[pos++];
                }
            }
        }

        return ans;
        
    }
}