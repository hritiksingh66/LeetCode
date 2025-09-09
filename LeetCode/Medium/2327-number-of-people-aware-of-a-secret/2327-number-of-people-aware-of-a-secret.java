class Solution {
    int M = 1000000007;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp , -1);

        dp[1] = 1; // we already know that till day 1 only one person knew the secret'

        for (int day = 2; day <= n; day++) {
            int count = 0;
            for (int prev = day - forget + 1; prev <= day - delay; prev++) {
                if(prev > 0){
                    count = (count + dp[prev]) % M;
                }
            }
            dp[day] = count;
        }


        int res = 0;

        for(int day = n - forget + 1 ; day <= n ; day++){
            res = (res + dp[day])%M;
        }

        return res;
    }
}