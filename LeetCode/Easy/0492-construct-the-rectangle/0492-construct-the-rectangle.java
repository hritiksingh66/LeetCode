class Solution {
    public int[] constructRectangle(int area){
        int[] ans = new int[2];
        int minDiff = Integer.MAX_VALUE;

        for(int w = 1; w*w <= area ; w++){
            if(area%w==0){
                int L = area/w;
                int diff = Math.abs(L-w);

                if(diff <= minDiff){
                    minDiff = diff;
                    ans[0] = Math.max(L,w);
                    ans[1] = Math.min(L,w);

                }
            }
        }

        return ans;
    }
}