class Solution {
    public int minDifference(int[] nums){

        int n = nums.length;

        Arrays.sort(nums);

        if(n<=4){
            return 0;
        }

        int result  = nums[n-1]-nums[0];

        for(int i = 0 ; i <= 3; i++){
            result = Math.min(result ,nums[n+i-4]-nums[i]);
        }

        return result;
        
    }
}