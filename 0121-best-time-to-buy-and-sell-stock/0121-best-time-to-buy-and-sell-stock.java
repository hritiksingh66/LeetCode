class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int minPrice = Integer.MAX_VALUE;

        int maxProfit = 0;


        for(int i = 0; i < n; i++){

            if(prices[i] < minPrice){
                minPrice = prices[i];
            }

            if(prices[i] > minPrice){
                maxProfit = Math.max(prices[i]-minPrice,maxProfit); 
            }

        }

        return maxProfit;
        
    }
}