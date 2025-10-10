class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int max=Integer.MIN_VALUE,n=energy.length;
        for(int i=0;i<k;i++){
            int sum=0,m=i;
            while(m<n){
                if(sum<0) sum=0;
                sum+=energy[m];
                m+=k;
            }
            max=Math.max(max,sum);
        }
        return max;
    }
}