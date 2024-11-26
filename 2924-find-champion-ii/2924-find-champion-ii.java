class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] arr = new int[n];
        for(int i=0;i<edges.length;i++)
        {
            arr[edges[i][1]]++;
        }
        int min = n+1;
        int ans = -1;
        for(int i=0;i<n;i++)
        {
            if(min>arr[i])
            {
                min = arr[i];
                ans = i;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]==min && i!=ans)
                return -1;
        }
        return ans;
    }
}