class Solution {
    public int findMaxConsecutiveOnes(int[] nums){
        int n = nums.length;
        int j = 0;

        int result = 0;
        int currCount = 0;

        while(j<n){
            if(nums[j]==1){
                currCount++;
            }else{
                currCount = 0;
            }
            j++;
            result = Math.max(result,currCount);
        }
        return result;
    }
}