class Solution {
    private int oneDArrayCount(List<Integer> list){
        int cons = 0;
        int subCount = 0;

        for(int col : list){
            if(col == 0){
                cons = 0;
            }else{
                cons++;
            }

            subCount += cons;
        }

        return subCount;
    }

    public int numSubmat(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        int result = 0;

        for(int beginR = 0 ; beginR < m ; beginR++){

            List<Integer> list = new ArrayList<>(Collections.nCopies(n, 1));

            for(int endR = beginR ; endR < m ; endR++){

                for(int col = 0 ; col < n ; col++){
                    list.set(col , list.get(col) & mat[endR][col]);
                }

                result += oneDArrayCount(list);
            }
        }

        return result;
    }
}