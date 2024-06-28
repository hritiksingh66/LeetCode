class Solution {
    public String removeDuplicates(String s) {
        int end = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (end > 0 && chars[end - 1] == chars[i]) {
                end--;
            } else {
                chars[end] = chars[i];
                end++;
            }
        }        
        return new String(chars, 0, end);
    }
}