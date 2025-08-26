class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions){
        int maxDiag = 0;
        int maxArea = 0;


        for(int[] dim : dimensions){

            int l = dim[0];
            int b = dim[1];

            int diag = l * l + b * b;
            int area = l*b;

            if(diag > maxDiag){
                maxDiag = diag;
                maxArea = area;
            }else if(diag == maxDiag){
                maxArea = Math.max(area,maxArea);
            }
        }

        return maxArea;
        
    }
}