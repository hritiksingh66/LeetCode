import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hs = new HashMap<>();
        int start = 0;
        int maxlength = 0;
        for (int i = 0; i < s.length(); i++) {

            // Agar character pahle se map me present hai aur uska idx current window me hi
            // hain
            if (hs.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) >= start) {
                // To start pointer ko current charactr ke last occurence ke right pe move karey
                start = hs.get(s.charAt(i)) + 1;
            }
            // update the index
            hs.put(s.charAt(i), i);
            //// Calculate the length of the current window and update maxLength
            maxlength = Math.max(maxlength, i - start + 1);

        }
        return maxlength;
    }
}