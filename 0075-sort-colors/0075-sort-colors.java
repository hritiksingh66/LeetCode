class Solution {
    public void sortColors(int[] nums){
        int n = nums.length;
        int zerothPos = 0;
        int onePos = 0;
        int twoPos = n-1;

        while(onePos <= twoPos){
            if(nums[onePos] == 1){
                onePos++;
            }else if(nums[onePos] == 2){
                int temp = nums[onePos];
                nums[onePos] = nums[twoPos];
                nums[twoPos] = temp;
                twoPos--;
            }else{
                int temp = nums[onePos];
                nums[onePos] = nums[zerothPos];
                nums[zerothPos] = temp;
                onePos++;
                zerothPos++;
            }
        }
        
    }
}