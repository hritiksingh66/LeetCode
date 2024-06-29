class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        for(int i=1;i<n;i++)
        {
            gain[i]=gain[i-1]+gain[i];
        }

        int[] ans=new int[n+1];
        for(int i=1;i<n+1;i++){
            ans[i]=gain[i-1];
        }

         int max = Integer.MIN_VALUE;
        for (int i = 0; i < n+1; i++)
        {
            if (ans[i] > max)
            {
                max = ans[i];
            }
        }

        return max;
    }
}