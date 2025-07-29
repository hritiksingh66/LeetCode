class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;

        int[] setBit = new int[32];
        // setBit[j] = i means that jth bit can be set via element at index i in nums

        Arrays.fill(setBit, -1);

        for (int i = n - 1; i >= 0; i--) {

            //nums[i] = binary represention
            int endIdx = i;
            for (int j = 0; j < 32; j++) {

                if ((nums[i] & (1 << j)) != 0) {
                    setBit[j] = i;
                }

                if ((nums[i] & (1 << j)) != 0) { 
                    if (setBit[j] != -1) {
                        endIdx = Math.max(setBit[j], endIdx);
                    }
                }if(setBit[j] != -1){
                    endIdx = Math.max(endIdx, setBit[j]);
                }
            }
            nums[i] = endIdx - i + 1;
        }
        return nums;
    }
}