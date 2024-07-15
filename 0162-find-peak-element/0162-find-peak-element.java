class Solution {
    public int findPeakElement(int[] nums){
        int n=nums.length;
        int peak_idx=0;
        int peak_element=nums[0];
        if(nums.length==1){
            return 0;
        }
        for(int i=1;i<=n-2;i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                if(nums[i]>peak_element){
                    peak_element=nums[i];
                    peak_idx=i;
                }
            }
        }
        if(nums[n-1]>nums[n-2] && n>=2){
            if(nums[n-1]>peak_element){
                peak_element=nums[n-1];
                peak_idx=n-1;
            }
        }
        return peak_idx;  
    }
}