class Solution {
    public char kthCharacter(long k, int[] operations) {
        int noOfOperations = 0;
        long val = k;

        while (val > 1) {
            int jumps = (int) Math.ceil(Math.log(val) / Math.log(2));
            val -= (1L << (jumps - 1)); // subtract 2^(jumps-1)
            noOfOperations += operations[jumps - 1];
        }

        return (char) ('a' + noOfOperations % 26);
    }
}
