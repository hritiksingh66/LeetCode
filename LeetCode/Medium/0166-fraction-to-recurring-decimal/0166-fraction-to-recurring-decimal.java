class Solution {
    public String fractionToDecimal(int num, int den) {
        if (num == 0)
            return "0";

        StringBuilder sb = new StringBuilder();

        if ((long)num*den < 0) {
            sb.append("-");
        }

        long absNum = Math.abs((long) num);
        long absDen = Math.abs((long) den);

        long intDiv = absNum / absDen;
        sb.append(intDiv);

        long rem = absNum % absDen;

        if (rem == 0) {
            return sb.toString();
        }

        sb.append(".");

        Map<Long, Integer> mp = new HashMap<>();

        while (rem != 0) {

            if (mp.containsKey(rem)) {
                int pos = mp.get(rem);
                sb.insert(pos, "(");
                sb.append(")");
                break;
            }

            mp.put(rem, sb.length());

            rem *= 10;

            long digit = rem / absDen;
            sb.append(digit);
            rem %= absDen;
        }

        return sb.toString();
    }
}