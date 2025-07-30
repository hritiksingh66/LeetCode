class Solution {
    public int longestSubarray(int[] nums){

        int maxValue = 0;
        int result = 0;
        int currStreak = 0;

        for(int num : nums){
            if(num > maxValue){
                maxValue = num;
                result = 0;
                currStreak = 0;
            }

            if(num == maxValue){
                currStreak++;
            }else{
                currStreak = 0;
            }

            result = Math.max(result , currStreak);
        }

        return result;
    }
}