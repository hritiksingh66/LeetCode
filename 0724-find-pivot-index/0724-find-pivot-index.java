class Solution {
    public int pivotIndex(int[] nums){
        int n = nums.length;

        int[] leftSum = new int[n];
        leftSum[0] = nums[0];

        for(int i = 1;i<n;i++){
            leftSum[i] = nums[i]+leftSum[i-1];
        }

        int totalSum = leftSum[n-1];

        int left = 0;
        int currLeftSum = 0; 
        int currRightSum = 0; 

        while(left < n){
            if(left==0){
                currLeftSum = 0;
            }else{
                currLeftSum = leftSum[left-1];
            }
            
            currRightSum = totalSum - leftSum[left];

            if(currLeftSum == currRightSum){
                return left;
            }else{
                left++;
            }
        }  
    return -1;  
    }
}