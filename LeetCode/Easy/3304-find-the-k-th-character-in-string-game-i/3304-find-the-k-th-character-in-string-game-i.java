class Solution {
    public char kthCharacter(int k) {
        String str = "a";
        while (str.length() < k) {
            int n = str.length();
            for (int i = 0; i < n; i++) {
                char ch = str.charAt(i);
                char addingChar = (ch == 'z') ? 'a' : (char) (ch + 1);
                str += addingChar;
            }
        }

        return str.charAt(k-1);

    }
}