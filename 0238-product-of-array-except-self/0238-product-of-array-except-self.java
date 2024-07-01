class Solution {
    public int[] productExceptSelf(int[] nums){

        int n = nums.length;


        int totalProd = 1 ;
        int zerosCount = 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i]!=0){
                totalProd *= nums[i];  
            }else{
                zerosCount++;
            }
        }

        if(zerosCount==n){
            totalProd = 0;
        }

        int[] result = new int[n];

        for(int i = 0 ; i < n; i++){
            if(zerosCount==0){
                int currProd = totalProd/nums[i];
                result[i] = currProd;
            }else if(zerosCount == 1){
                if(nums[i]!=0){
                    result[i] = 0;
                }else{
                    result[i] = totalProd;
                }
            }else{
                result[i] = 0;
            }
        }

        return result;
        
    }
}