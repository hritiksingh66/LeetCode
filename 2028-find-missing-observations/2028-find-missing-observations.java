class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n){
        int m = rolls.length;

        int rollSum = 0;

        for(int rollVal : rolls){
            rollSum += rollVal;
        }

        int totalSum = (m+n) * mean;

        int remTotal = totalSum - rollSum;

        if(remTotal < n || remTotal > n*6){
            return new int[0];
        }

        int []ans = new int[n];
        int pos = 0;

        while(remTotal > 0){
            int dice = Math.min(remTotal - n + 1,6);
            ans[pos++] = dice;
            remTotal -= dice;
            n--; 
        }

        return ans;
    }
}