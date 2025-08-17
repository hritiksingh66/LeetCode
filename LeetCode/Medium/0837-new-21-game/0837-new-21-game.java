class Solution {
    public double new21Game(int n, int k, int maxPts){
        double[] p = new double[n+1];

        p[0] = 1;

        double probSum = (k==0) ? 0 : 1;

        for(int i = 1; i <= n; i++){
            p[i] = probSum/maxPts;

            if(i < k){
                probSum += p[i];
            }
            if( i - maxPts >= 0 && i-maxPts < k){
                probSum -= p[i-maxPts];
            }
        }

        double res = 0;

        for(int i = k ; i <= n ; i++){
            res += p[i];
        }

        return res;
    }
}