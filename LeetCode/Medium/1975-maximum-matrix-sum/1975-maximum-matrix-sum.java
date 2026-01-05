class Solution {
    public long maxMatrixSum(int[][] matrix){
        int m = matrix.length; 
        int n = matrix[0].length;

        int min = Integer.MAX_VALUE;
        long sum = 0;
        boolean odd = false;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int val = matrix[i][j];

                if(val < 0){
                    odd = !odd;
                    val = -val;
                }

                sum += val;


                if(val < min){
                    min = val;
                }
            }
        }

        return odd ? sum - 2L * min : sum;  
    }
}