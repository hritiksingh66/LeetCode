class Solution {
    public long maximumImportance(int n, int[][] roads){

        int[] arr = new int[n];

        for(int i = 0; i < roads.length ; i++){

            int u = roads[i][0];
            int v = roads[i][1];

            arr[u]++;
            arr[v]++;
        }

        Arrays.sort(arr);

        int result = 0;

        for(int i = 0 ; i < n ; i++){

            result+=(i+1)*(arr[i]);
        }

        return result;
    }
}