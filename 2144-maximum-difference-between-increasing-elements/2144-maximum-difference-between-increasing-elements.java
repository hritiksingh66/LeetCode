class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;

        int i = 0;
        int j = 1;

        int result = -1;

        while(i<j && j<n){
            if(nums[i]<nums[j]){
                int diff = (nums[j]-nums[i]);
                result = Math.max(result,diff);
            }else{
                i=j;
            }
            j++;
        }
        return result;
    }
}