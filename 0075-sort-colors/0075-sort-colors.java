class Solution {
    public void sortColors(int[] nums){
        int n = nums.length;
        for(int i=1;i<n;i++){
            int j=i;
            while(j>0 && nums[j]<nums[j-1]){
                int temp = nums[j];
                nums[j]=nums[j-1];
                nums[j-1]=temp;
                j--;
            }
        }
    }
}