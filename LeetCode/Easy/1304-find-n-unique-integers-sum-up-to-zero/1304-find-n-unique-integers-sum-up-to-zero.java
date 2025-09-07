class Solution {
    public int[] sumZero(int n){
        if(n==1) return new int[]{0};
        int start = -1 * n/2;
        int end = n / 2;
        int[] res = new int[n];
        int pos = 0;
        for(int i = start ; i <= end ; i++){
            if(n%2 == 0 && i==0) continue;
            res[pos++] = i;
        }

        return res;
    }
}