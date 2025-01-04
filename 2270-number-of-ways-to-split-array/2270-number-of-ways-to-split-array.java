class Solution {
    public int waysToSplitArray(int[] nums) {
        int i, n = nums.length, c = 0;
        long suml = 0, sumr = 0, sum = 0;
        System.out.println(n);
        for(i = 0; i<n; i++){
            sum = sum + nums[i];
        }
        suml = nums[0];
        sumr = sum - suml;
        for(i = 0; i<n-1; i++){
            if(i>0){
                suml = suml + nums[i];
                sumr = sum - suml;
            }
            if(suml >= sumr){
                c++;
            }
        }
        return c;
    }
}