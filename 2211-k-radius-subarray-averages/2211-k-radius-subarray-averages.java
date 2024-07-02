class Solution {
    public int[] getAverages(int[] nums, int k){
        int n = nums.length;

        if(k==0){
            return nums;
        }

        int[] result = new int[n];
        Arrays.fill(result , -1);

        if(n < 2*k+1){
            return result;
        }

        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for(int i = 1 ; i < n ; i++){
            prefixSum[i]=nums[i]+prefixSum[i-1];
        }

        for(int i = k ; i <= n-k-1; i++){

            int left_idx = i-k;
            int right_idx = i+k;

            long sum = prefixSum[right_idx];

            if(left_idx > 0){
                sum -= prefixSum[left_idx-1];
            }
            result[i] = (int)(sum/(2*k+1));
        }
        return result;
    }
}