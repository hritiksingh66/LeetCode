class Solution {
    public int longestOnes(int[] nums, int k){

        int n = nums.length;

        int left = 0, right = 0 , zeros = 0;
        int maxAns = 0, curr_length = 0;

        while(right < n){
            if(nums[right]==0) zeros++;

            while(zeros > k){
                if(nums[left]==0) zeros--;
                left++;
            }

            if(zeros <= k){
                curr_length = right - left + 1;
                maxAns = Math.max(maxAns , curr_length);
            }

            right++;
        }

        return maxAns;
    }
}