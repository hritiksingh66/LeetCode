class Solution {
    public int maxSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1] && nums[i]>0){
                sum+=nums[i];
            }
            
        }
        sum+=nums[nums.length-1];
        return sum;
    }
}