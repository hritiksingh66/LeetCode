class Solution {
    public int maximumSwap(int num) {
        // Convert the number to string and then to a character array
        char[] str = Integer.toString(num).toCharArray();
        int n = str.length;
        
        // Array to store the index of the maximum element to the right of each element
        int[] maxRight = new int[n];
        
        // The last element is its own maximum
        maxRight[n - 1] = n - 1;
        
        // Populate the maxRight array
        for (int i = n - 2; i >= 0; i--) {
            int rightMaxIdx = maxRight[i + 1];
            // Compare the current element with the right maximum element
            maxRight[i] = (str[i] > str[rightMaxIdx]) ? i : rightMaxIdx;
        }

        // Traverse the string to find the first place to swap
        for (int i = 0; i < n; i++) {
            int maxRightIdx = maxRight[i];
            if (str[i] < str[maxRightIdx]) {
                // Perform the swap
                char temp = str[i];
                str[i] = str[maxRightIdx];
                str[maxRightIdx] = temp;
                
                // Convert back to integer and return
                return Integer.parseInt(String.valueOf(str));
            }
        }
        
        // If no swap was done, return the original number
        return num;
    }
}
