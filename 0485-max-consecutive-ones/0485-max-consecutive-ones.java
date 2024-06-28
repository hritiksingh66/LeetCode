class Solution {
    public int findMaxConsecutiveOnes(int[] nums){
        int n = nums.length;
        int i = 0, j = 0;

        int result = 0;
        int currCount = 0;

        while(j<n){
            if(nums[j]==1){
                currCount++;
                j++;
                result = Math.max(result,currCount);
            }else{
                currCount = 0;
                j++;
                i=j;
            }
        }
        return result;
    }
}