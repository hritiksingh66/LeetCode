class Solution 
{
    public int solve(int cost[],int n,int[] dp)
    {
        //step1:base case
        if(n==0 || n==1)
        return cost[n];

        //step3:completed
        if(dp[n] != -1)
        return dp[n];

        //step2
        dp[n]=cost[n]+Math.min(solve(cost, n-1 ,dp) , solve(cost , n-2 , dp));
        return dp[n];

    }
    public int minCostClimbingStairs(int[] cost) 
    {
        int n=cost.length;

        int dp[]=new int[n+1];
        for(int i=0;i<n+1;i++)
        {
            dp[i]=-1;
        }
        int ans=Math.min(solve(cost, n-1 ,dp) , solve(cost , n-2 , dp));
        return ans;
    }
}