class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;

        int formedNo = 0;

        // x = Math.abs(x);

        while (x > 0) {
            formedNo = (formedNo * 10) + x % 10;
            x = x / 10;
        }

        return temp == formedNo;
    }
}