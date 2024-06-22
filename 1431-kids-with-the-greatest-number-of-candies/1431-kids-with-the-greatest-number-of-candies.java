class Solution {
    List<Boolean> result = new ArrayList<>();
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies){
        
        int n = candies.length;
        
        int highest = Integer.MIN_VALUE;
        
        for(int i = 0; i<n;i++){
            highest = Math.max(highest,candies[i]);
        }
        
        for(int j = 0;j<n;j++){
            if((candies[j]+extraCandies)>=highest){
                result.add(true);
                continue;
            }
            result.add(false);
        }
        
        return result;
        
    }
}