class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        int conseOddsCount = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] & 1) == 1) {
                conseOddsCount++;
                if (conseOddsCount == 3)
                    return true;
            } else {
                conseOddsCount = 0;
            }
        }
        return false;
    }
}