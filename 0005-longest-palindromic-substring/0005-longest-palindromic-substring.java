class Solution {

    public static int start;
    public static int end;
    public static String longestPalindrome(String s) {
        start = 0;
        end =0;
        
        if(s.length()<=1) return s;

        helper(s.toCharArray(), 0);

        return s.substring(start, end+1);
    }

    private static void helper(char[] charArray, int i) {
        int n = charArray.length;

        if (i > n-1) return;

        int left = i, right = i;

        while(right < n-1 && charArray[right] == charArray[right +1]) right ++;

        i = right;

        while (left>0 && right <n-1 && charArray[left-1] == charArray[right+1]){
            left--;
            right++;
        }

        if(right -left > end - start) {
            start = left;
            end = right;
        }

        helper(charArray, ++i);
    }
}