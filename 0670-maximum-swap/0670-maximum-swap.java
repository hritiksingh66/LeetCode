class Solution {
    public int maximumSwap(int num) {
        char[] str = Integer.toString(num).toCharArray();
        int n = str.length;
        
        int[] maxRight = new int[n];
        
        maxRight[n - 1] = n - 1;
        
        for (int i = n - 2; i >= 0; i--) {
            int rightMaxIdx = maxRight[i + 1];
            maxRight[i] = (str[i] > str[rightMaxIdx]) ? i : rightMaxIdx;
        }

        for (int i = 0; i < n; i++) {
            int maxRightIdx = maxRight[i];
            if (str[i] < str[maxRightIdx]) {
                char temp = str[i];
                str[i] = str[maxRightIdx];
                str[maxRightIdx] = temp;
                
                return Integer.parseInt(String.valueOf(str));
            }
        }
        
        return num;
    }
}
