class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int num = low; num <= high; num++) {
            if (num >= 10 && num < 100 && num % 11 == 0) {
                count++;
            } 
            else if (num >= 1000 && num < 10000) {
                int d1 = (num / 1000) % 10;
                int d2 = (num / 100) % 10;
                int d3 = (num / 10) % 10;
                int d4 = num % 10;

                if ((d1 + d2) == (d3 + d4)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
