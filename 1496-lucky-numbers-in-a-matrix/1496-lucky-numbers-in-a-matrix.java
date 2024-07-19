class Solution{
    public List<Integer> luckyNumbers (int[][] matrix){
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rowMin = new int[m];
        int[] colMax = new int[n];

        for(int row = 0 ; row < m ; row++){
            int minEl = Integer.MAX_VALUE;
            for(int col = 0 ; col < n ; col++){
                minEl = Math.min( minEl , matrix[row][col]);
            }
            rowMin[row] = minEl;
        }

        for(int col = 0 ; col < n ; col++){
            int maxEl = Integer.MIN_VALUE;
            for(int row = 0 ; row < m ; row++){
                maxEl = Math.max( maxEl , matrix[row][col]);
            }
            colMax[col] = maxEl;
        }

        for(int row = 0 ; row < m ; row++){
            for(int col = 0 ; col < n ; col++){
                int val = matrix[row][col];
                if(val == rowMin[row] && val == colMax[col]){
                    result.add(val);
                }
            }
        }

        return result;
    }
}