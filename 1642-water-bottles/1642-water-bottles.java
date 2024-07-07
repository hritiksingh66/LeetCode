class Solution {
    public int numWaterBottles(int numBottles, int numExchange){
        int ans = numBottles;

        while((numBottles >= numExchange)){
            int remainder = numBottles % numExchange;
            int quot = numBottles / numExchange;
            ans += quot;
            numBottles = remainder + quot ;
        }
        return ans;
    }
}