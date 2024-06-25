class Solution{
    int M = 1000000007;
    public int numberOfGoodPartitions(int[] nums){
        int n = nums.length;
        
        Map<Integer, Integer> last_index = new HashMap<>(); // number->last index
        
        for(int i = 0; i < n ;i++){
            last_index.put(nums[i],i);
        }
        
        int i = 0;
        int j = 0;
        j = Math.max(j,last_index.get(nums[0]));
        
        int result = 1;
        
        while(i<n){
            if(i>j){ // we got a partition 
                result = (result * 2) % M;
            }
            
            j = Math.max(j,last_index.get(nums[i]));
            i++;
        }
        
        return result;
    }
}