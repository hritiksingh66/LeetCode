class Solution {
    public int reverse(int x) {
        int revNo = 0;

        while (x != 0) {
            int lastDigit = x % 10;

            // Check for overflow/underflow before multiplying by 10
            if (revNo > Integer.MAX_VALUE / 10 || (revNo == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0;
            }
            if (revNo < Integer.MIN_VALUE / 10 || (revNo == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0;
            }

            revNo = (revNo * 10) + lastDigit;
            x = x / 10;
        }

        return revNo;
    }
}
