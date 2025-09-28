// Approach - 1
// TC = O(n)  as we are iterating only one for loop n times
// SC = O(n)  as we declared a new boolean of size n , means using extra space 
class Solution{
    public int minKBitFlips(int[] nums, int k){
        
        int n = nums.length;
        
        int flips = 0;
        
        int flipCountFromPastFori = 0;
        
        boolean[] isFlipped = new boolean[n];
        Arrays.fill(isFlipped,false);
        
        for(int i = 0; i < n; i++){
            if(i>=k && isFlipped[i-k] == true){
                flipCountFromPastFori--;           
            }
            
            if(flipCountFromPastFori % 2 == nums[i]){ //flip at index i
                if(i + k > n){
                    return -1;
                }
                flipCountFromPastFori++;
                flips++;
                isFlipped[i] = true;
            }
        }
        return flips;
    }
}