class Solution {
    public int findMiddleIndex(int[] nums){
        int n = nums.length;

        int totalSum = 0;

        for(int i = 0; i < n ; i++){
            totalSum += nums[i];
        }

        int left = 0;

        int leftSum = 0;
        int rightSum = 0;

        while( left < n){
            if(left>0){
                leftSum += nums[left-1];
            }
            rightSum = totalSum - (leftSum + nums[left]);
            if(leftSum == rightSum){
                return left;
            }
            left++;
        }
        return -1;
    }
}