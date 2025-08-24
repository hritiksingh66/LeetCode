class Solution {
    public int longestSubarray(int[] nums){

        int n = nums.length;

        int i = 0;

        int zerosCount = 0;
        int result = 0;

        for(int j = 0 ; j < n ; j++){

            if(nums[j]==0) zerosCount++;

            while(zerosCount > 1){
                if(nums[i]==0) zerosCount--;
                i++;
            }

            result = Math.max(result , j-i);
        }

        return result;
        
    }
}