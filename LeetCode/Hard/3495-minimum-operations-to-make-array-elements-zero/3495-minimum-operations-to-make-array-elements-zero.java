class Solution {
    public long minOperations(int[][] queries){
        long res = 0;

        for(int[] q : queries){
            int l = q[0];
            int r = q[1];

            long step = solve(l, r);

            res += (step+1)/2;
        }

        return res;
    }

    private long solve(int l, int r){
        long L = 1;
        long S = 1;
        long steps = 0;

        while(L <= r){
            long R = L*4 - 1;

            long start = Math.max((long)l,L);
            long end = Math.min(R,(long)r);

            if(start <= end){
                steps += (end-start + 1) * S; 
            }

            S++;
            L = L*4 ;
        }

        return steps;
    }
}