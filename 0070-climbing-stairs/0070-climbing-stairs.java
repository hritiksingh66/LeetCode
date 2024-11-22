class Solution {
    public int climbStairs(int n){
        if(n <= 3) {
            return n;
        }

        int c = 2;
        int d = 3;

        for(int i = 4 ; i <= n; i++){
            int result = c+d;
            c = d; 
            d = result;
        }

        return d;

    }
}