class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int l = 100000 , i = 0;
        int ans = 0;

        while( i < nums.length){
            if(nums[i]>threshold || (i>0 && nums[i]%2==nums[i-1]%2)){
                ans = Math.max(ans,i-l);
                l=100000;
            }

            if(l==100000 &&  nums[i]<=threshold && nums[i]%2==0){
                l=i;
            }
            i++;
        }
        ans = Math.max(ans,i-l);
        return ans;
    }
}