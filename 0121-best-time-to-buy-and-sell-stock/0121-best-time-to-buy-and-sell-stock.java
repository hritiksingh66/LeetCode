class Solution {
    public int maxProfit(int[] nums) {

        int n = nums.length;

        int min = nums[0];

        int ans = 0;


        for(int i = 1; i < n; i++){

            if(nums[i] > min){
                ans = Math.max(nums[i]-min,ans); 
            }

            if(nums[i] < min){
                min = nums[i];
            }

        }

        return ans;
        
    }
}