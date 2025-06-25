class Solution {
    public int removeDuplicates(int[] nums){
        int n = nums.length;

        // if(n==1){
        //     return 1;
        // }

        int i = 0;

        for(int j = 1 ; j < n ; j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }

        return i+1;
    }
}