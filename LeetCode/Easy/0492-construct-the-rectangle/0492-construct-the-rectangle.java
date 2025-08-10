class Solution {
    public int[] constructRectangle(int area){
        for(int w =(int)Math.sqrt(area); w >= 1;w--){
            if(area%w==0){
                return new int[]{area/w,w};
            }
        }

    return new int[]{0,0};
}}