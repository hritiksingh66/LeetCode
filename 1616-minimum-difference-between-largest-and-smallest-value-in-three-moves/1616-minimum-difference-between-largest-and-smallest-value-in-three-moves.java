class Solution {
    public int minDifference(int[] nums){

        int n = nums.length;

        Arrays.sort(nums);

        if(n<=3){
            return 0;
        }

        int result  = Integer.MAX_VALUE;

        for(int i = 1 ; i <= 4; i++){
            result = Math.min(result , Math.abs(nums[n - i] - nums[ 4 - i]));
        }

        return result;
        
    }
}