class Solution {
    public int[] xorQueries(int[] arr, int[][] queries){

        int n = queries.length;

        int[] ans = new int[n];

        int pos = 0;

        for(int[] queri : queries){
            int left = queri[0];
            int right = queri[1];

            int ansTemp = arr[left];

            for(int i = left+1 ; i <= right ; i++){
                ansTemp = ansTemp^arr[i];
            }
            ans[pos++] = ansTemp;
        }

        return ans;
        
    }
}