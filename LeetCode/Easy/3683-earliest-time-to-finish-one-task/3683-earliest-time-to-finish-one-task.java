class Solution {
    public int earliestTime(int[][] tasks){
        int ans = 201;

        for(int[] task : tasks){
            int finish = task[0] + task[1];
            ans = Math.min(finish , ans);
        }

        return ans;
    }
}