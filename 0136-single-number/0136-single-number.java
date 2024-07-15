class Solution {
    public int singleNumber(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                    if (nums[i] == nums[j])
                    {
                        nums[i]=-1;
                        nums[j]=-1;
                    }
            }
        }
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=-1){
                ans=nums[i];
            }
        }
        return ans;
    }
}