class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int target = 0;
        for (int num : nums) {
            target = (target + num) % p;
        }
        
        if (target == 0) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currSum = 0, res = n;
        
        for (int i = 0; i < n; i++) {
            currSum = (currSum + nums[i]) % p;
            int key = (currSum - target + p) % p;
            
            if (map.containsKey(key)) {
                res = Math.min(res, i - map.get(key));
            }
            
            map.put(currSum, i);
        }
        
        return res < n ? res : -1;
    }
}