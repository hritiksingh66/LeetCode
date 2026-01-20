class Solution {
    public int[] minBitwiseArray(List<Integer> nums){
        int n = nums.size();
        int[] ans = new int[n];
        int i = 0;

        for(Integer num : nums){
            if(num%2 == 0){
                ans[i++] = -1;
            }else{
                int trailingOnes = Integer.numberOfTrailingZeros(~num);

                ans[i++] = num - (1 << (trailingOnes - 1));
            }
        }

        return ans;
        

    }
}