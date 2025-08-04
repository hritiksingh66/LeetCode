// class Solution {
//     public int myAtoi(String s) {
//         int n = s.length();
//         int i = 0;

//         while( i < n && s.charAt(i) == ' '){ // skip leading white spaces
//             i++;
//         }

//         int sign = 1;

//         while(i < n && (s.charAt(i)=='+' || s.charAt(i)=='-')){
//            sign = s.charAt(i)=='+' ? 1 : -1;
//            i++;
//         }

//         int result = 0; 

//         while (i < n && Character.isDigit(s.charAt(i))){
//             result = result * 10 + (s.charAt(i) - '0');
//             if(sign * result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
//             if(sign * result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
//             i++;
//         }

//         return (int)(sign * result);
//     }
// }
class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();

        // 1. Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        long result = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            if (sign * result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }

        return (int)(sign * result);
    }
}
