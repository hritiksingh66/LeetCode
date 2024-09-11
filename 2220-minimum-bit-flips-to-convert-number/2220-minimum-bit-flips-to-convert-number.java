class Solution {
    public int minBitFlips(int start, int goal){
        int ans = start ^  goal;
        int count = 0;

        while(ans > 0){ // TC -> O(log2(ans))
            if(ans%2 == 1){
                count++;
            }
            ans = ans/2;
        }
        
        return count;
    }
}