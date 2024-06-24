class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        
        int flips = 0;
        
        int flipCountFromPastFori = 0;
        

        for(int i = 0; i < n; i++){
            if(i>=3 && nums[i-3] == 5){
                flipCountFromPastFori--;           
            }
            
            if(flipCountFromPastFori % 2 == nums[i]){ //flip at index i
                if(i + 3 > n){
                    return -1;
                }
                flipCountFromPastFori++;
                flips++;
                nums[i] = 5;
            }
        }
        return flips;
    }
}