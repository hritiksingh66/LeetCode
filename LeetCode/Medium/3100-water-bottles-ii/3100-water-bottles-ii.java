class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange){
        int ans = numBottles;

        int emtyBott = numBottles;

        while(emtyBott >= numExchange){
            emtyBott = emtyBott - numExchange + 1;
            numExchange += 1;
            ans += 1;
        }

        return ans;
        
    }
}