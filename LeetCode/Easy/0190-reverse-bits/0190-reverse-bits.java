class Solution {
    public int reverseBits(int n) {
        String binary = String.format("%32s", Integer.toBinaryString(n))
                    .replace(' ', '0');

        String reversed = new StringBuilder(binary).reverse().toString();

        int res = 0;

        for(char ch : reversed.toCharArray()){
            int val = ch-'0';
            res = res*2 + val;

        }
    
        return res;
    }
}