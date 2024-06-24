class Solution {
    public int minPairSum(int[] nums){
        
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int i = 0,j=n-1;
        
        int result = 0;
        
        while(i < j){
            int sum = nums[i] + nums[j];
            result = Math.max(result,sum);
            i++;
            j--;
        }
        
        return result;
    }
}