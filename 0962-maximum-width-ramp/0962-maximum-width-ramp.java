class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        
        int[] maxToRight = new int[n];
        maxToRight[n - 1] = nums[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            maxToRight[i] = Math.max(maxToRight[i + 1], nums[i]);
        }
        
        int maxRamp = 0;
        int i = 0, j = 0;
        
        while (j < n) {
            if (nums[i] <= maxToRight[j]) {
                maxRamp = Math.max(maxRamp, j - i);
                j++;  
            } else {
                i++;  
            }
        }
        
        return maxRamp;
    }
}
