class Solution {
    public int minimumLength(String s) {
        if (s.length() < 3) {
            return s.length();
        }
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 2) {
                if (freq[i] % 2 != 0) {
                    freq[i] = 1;
                } else {
                    freq[i] = 2;
                }
            }
        }
        return Arrays.stream(freq).sum();
    }
}
