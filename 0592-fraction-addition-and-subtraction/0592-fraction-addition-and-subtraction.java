class Solution {
    public String fractionAddition(String exp) {
        int num = 0;
        int deno = 1;

        int i = 0;
        int n = exp.length();
        while (i < n) {
            int currNum = 0;
            int currDen = 0;

            boolean isNeg = exp.charAt(i) == '-';

            if (exp.charAt(i) == '+' || exp.charAt(i) == '-') {
                i++;
            }

            // form the currNum
            while (i < n && Character.isDigit(exp.charAt(i))) {
                int val = exp.charAt(i) - '0';
                currNum = currNum * 10 + val;
                i++;
            }

            i++; // skip the "/" sign

            if (isNeg) {
                currNum *= -1;
            }

            // form the currDeno
            while (i < n && Character.isDigit(exp.charAt(i))) {
                int val = exp.charAt(i) - '0';
                currDen = currDen * 10 + val;
                i++;
            }

            num = num * currDen + currNum * deno;
            deno = deno * currDen;
        }

        int gcd = Math.abs(findGCD(num, deno));

        num /= gcd;
        deno /= gcd;

        return Integer.toString(num) + "/" + Integer.toString(deno);

    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}