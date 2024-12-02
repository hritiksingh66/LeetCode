class Solution {
    public String convert(String s, int numRows) {
        String[] ans = new String[numRows];

        for (int i = 0; i < numRows; i++) {
            ans[i] = "";
        }
        int i = 0;
        while (i < s.length()) {

            // Top to Down that is from 0th row to (numRow - 1)th row in same column
            for (int idx = 0; idx < numRows && i < s.length(); idx++) {
                ans[idx] += s.charAt(i++);

            }

            // Bottom to Up :- From (numRows - 2)th row to 1st row
            for (int idx = numRows - 2; idx > 0 && i < s.length(); idx--) {
                ans[idx] += s.charAt(i++);
            }

        }

        String res = "";
        for (String str : ans) {
            res += str;
        }

        return res;
    }
}