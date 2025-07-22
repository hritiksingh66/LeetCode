class Solution {
    public int maximumUniqueSubarray(int[] nums){
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];

        for(int i = 1; i < n; i++){
            preSum[i] = nums[i]+preSum[i-1];
        }

        int[] map = new int[10001];
        Arrays.fill(map,-1);


        int res = 0,sum = 0;
        int i = 0,j = 0;

        while(j < n){
            i = Math.max(i,map[nums[j]] + 1);
            int jthSum = preSum[j];
            int ithSum = (i<1) ? 0 :preSum[i-1];
            sum = jthSum - ithSum;
            res = Math.max(sum,res);
            map[nums[j]] = j;
            j++;
        } 


        return res;
        
    }
}