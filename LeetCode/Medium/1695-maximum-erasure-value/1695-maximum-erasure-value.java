class Solution {
    public int maximumUniqueSubarray(int[] nums){
        int n = nums.length;

        Set<Integer> set = new HashSet<>();

        int res = 0;
        int sum = 0;
        int i = 0 , j = 0;

        while(j < n){
            if(!set.contains(nums[j])){
                sum += nums[j];
                res = Math.max(sum,res);
                set.add(nums[j]);
                j++;
            }else{
                while(set.contains(nums[j])){
                    sum -= nums[i];
                    set.remove(nums[i]);
                    i++; 
                }
            }
        } 

        return Math.max(res,sum);
    }
}