class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK){

        int minIdx = -1;
        int maxIdx = -1;
        int culIdx = -1;

        long ans = 0;

        for(int i = 0 ; i < nums.length ; i++){
            // Update karey culIdx ko agar koi culprit element milta hai toh
            if(nums[i] < minK || nums[i] > maxK)
                culIdx = i;

            // Update karey minIdx ko agar koi new minK element milta hai toh
            if(nums[i] == minK)
                minIdx = i;

            // Update karey maxIdx ko agar koi new maxK element milta hai toh
            if(nums[i] == maxK)
                maxIdx = i;

            // Jo minimum ho usme se culpritIdx ko subtract karey aur agr zero se greater hai to utna number of subarray mila usey ans me add krey warna zero se less than ke liye zero add krey qki ek bhi subarray nahi mila waisa
            long smaller = Math.min(minIdx , maxIdx);
            long temp = smaller - culIdx;

            ans += (temp <= 0) ? 0 : temp;
        }

        return ans;
    }
}