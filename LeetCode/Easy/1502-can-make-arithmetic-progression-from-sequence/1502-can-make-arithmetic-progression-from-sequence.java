class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int diff = max - min;
        if (diff % (n - 1) != 0) return false;

        int cd = diff / (n - 1);
        if (cd == 0) return true;

        int i = 0;
        while (i < n) {
            if (arr[i] == min + i * cd) {
                i++;
            } else {
                int k = (arr[i] - min) / cd;

                if ((arr[i] - min) % cd != 0 || arr[i] == arr[k]) return false;

                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        return true;
    }
}
