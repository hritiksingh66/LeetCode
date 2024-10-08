class Solution {
    public int minSwaps(String s) {
        int balance =0, replace = 0, n = s.length(); 
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '[' ) {
                balance+=1;
            } else {
                balance-=1;
                if (balance <0) {
                    balance=1;
                    replace++;
                }
            }
        }
        return replace;
    }
}