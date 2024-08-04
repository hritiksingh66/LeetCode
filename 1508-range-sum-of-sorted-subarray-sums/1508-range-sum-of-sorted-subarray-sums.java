import java.util.Arrays;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = 1000000007;
        int totalSubarrays = n * (n + 1) / 2;
        int[] subarraySums = new int[totalSubarrays];
        int index = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarraySums[index++] = sum;
            }
        }

        Arrays.sort(subarraySums);

        int resultSum = 0;
        for (int i = left - 1; i < right; i++) {
            resultSum = (resultSum + subarraySums[i]) % MOD;
        }

        return resultSum;
    }
}
