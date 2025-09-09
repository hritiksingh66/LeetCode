class Solution {
    int M = 1000000007;
    int f;
    int del;

    public int peopleAwareOfSecret(int n, int delay, int forget){
        int total = 0;
        f = forget;
        del = delay;
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);

        for(int day = n-forget+1 ; day <= n ; day++){
            if(day > 0){
                total = (total + solve(day,dp)) % M; 
            }
        }

        return total;
    }

    public int solve(int day,int[] dp){
        if(day == 1){
            return 1;
        }

        if(dp[day] != -1){
            return dp[day];
        }

        int res = 0;

        for(int d = day-f+1 ; d <= day-del ; d++){
            if(d > 0){
                res = (res + solve(d,dp))%M;
            }
        }

        return dp[day] = res;
    }
}