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

        long result = 0;

        long value = 1;

        for(int i = 0 ; i < n ; i++){

            result+=(arr[i])*value;
            value++;
        }

        return result;
    }
}