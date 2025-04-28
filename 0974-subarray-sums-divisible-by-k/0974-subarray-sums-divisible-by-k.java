class Solution {
    public int subarraysDivByK(int[] nums, int k){
        int[] freq = new int[k];
        freq[0] = 1;
        int cumSum = 0 , result = 0;
        for (int num : nums){
            cumSum += num;
            int rem = cumSum % k;
            if(rem < 0) rem += k;
            result += freq[rem];
            freq[rem]++;
        }
        return result;
    }
}