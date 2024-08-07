class Solution {
    public int longestSubarray(int[] nums){

        int n = nums.length;

        int i = 0 , j = 0 , last_zero_idx = -1 , result = 0;

        while(j < n ){
            if(nums[j]==0){ 
                i = last_zero_idx + 1;
                last_zero_idx = j;
            }
            result = Math.max(result , j-i);
            j++;
        }
        return result;
    }
}