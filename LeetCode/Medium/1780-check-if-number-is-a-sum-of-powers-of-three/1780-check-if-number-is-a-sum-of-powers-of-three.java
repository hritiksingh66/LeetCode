class Solution {
    public boolean checkPowersOfThree(int n){
        int k = (int)(Math.log(n)/Math.log(3));
        System.out.println(k);
        while(k>=0){
            double diff = Math.pow(3,k);
            if(diff<=n){
                n-=diff;
            }
            k--;
        }
        return n==0;
    }
}