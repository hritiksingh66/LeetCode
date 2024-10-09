/*
Another solution without using stack, Using only Variable..
2nd Approch is same but only diff is increment and decrement method.
*/

class Solution {
    public int minAddToMakeValid(String s) {
        int st = 0;
        int open = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                st++;
            } else if(st > 0) {
                st--;
            } else {
                open++;
            }
        }
        return open + st;
    }
}