class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int currSubLen = 0;
        long res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                currSubLen++;
            } else {
                if (currSubLen > 0) {
                    res += (long)currSubLen * (currSubLen + 1)/2;
                    currSubLen = 0;
                }
            }
        }

        if(currSubLen > 0){
            res += (long)currSubLen * (currSubLen + 1)/2;
        }

        return res;
    }
}