class Solution {
    public int countLargestGroup(int n) {
        int[] arr = new int[n + 1];
        int max = 0;
        int count = 0;

        for (int num = 1; num <= n; num++) {

            int digit = num;
            int digitSum = 0;

            while (digit > 0) {
                digitSum += digit % 10;
                digit /= 10;
            }

            arr[digitSum]++;

            max = Math.max(max, arr[digitSum]);
        }

        for(int i=1;i<arr.length;i++){
            if(arr[i] == max) count++;
        }

        return count;

    }
}