// Approach - 2
// In this approach we did a liitle change in approach 1 i.e, we dont need to use any extra space 
// instead of that ... mark the flipped index of nums with any  integer value other than 0 and 1
// TC = O(n)  as we are iterating only one for loop n times
class Solution{
    public int minKBitFlips(int[] nums, int k){
        
        int n = nums.length;
        
        int flips = 0;
        
        int flipCountFromPastFori = 0;
        

        for(int i = 0; i < n; i++){
            if(i>=k && nums[i-k] == 5){
                flipCountFromPastFori--;           
            }
            
            if(flipCountFromPastFori % 2 == nums[i]){ //flip at index i
                if(i + k > n){
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