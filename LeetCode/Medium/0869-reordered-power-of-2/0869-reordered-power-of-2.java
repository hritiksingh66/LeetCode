class Solution {
    public int[] getCountFormat(int n){
        int[] counter = new int[10];

        while(n>0){
            counter[n%10]++;
            n/=10;
        }

        return counter;
    }
    public boolean reorderedPowerOf2(int n) {

        int[] input = getCountFormat(n);

       for (int p = 0; p <= 29; p++) {
            if (Arrays.equals(input, getCountFormat(1 << p))) {
                return true;
            }
        }

        return false;
    }
}