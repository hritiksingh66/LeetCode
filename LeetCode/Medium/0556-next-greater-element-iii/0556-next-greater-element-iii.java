class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;

        int idx = len - 2;
        while (idx >= 0 && digits[idx] >= digits[idx + 1]) idx--;
        if (idx < 0) return -1;

        int swapIdx = len - 1;
        while (digits[swapIdx] <= digits[idx]) swapIdx--;

        swap(digits, idx, swapIdx);
        reverse(digits, idx + 1, len - 1);

        long result = Long.parseLong(new String(digits));
        return (result > Integer.MAX_VALUE) ? -1 : (int) result;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) swap(arr, start++, end--);
    }
}
