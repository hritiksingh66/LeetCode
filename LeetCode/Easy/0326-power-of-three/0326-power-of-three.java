class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        int maxPower = (int)Math.pow(3,19);
        return maxPower%n==0;
    }
}