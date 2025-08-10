import java.util.*;

class Solution {
    public String sortedStr(int n) {
        StringBuilder sb = new StringBuilder(n + "");

        sb.replace(0, sb.length(),
            sb.toString().chars()
              .sorted()
              .collect(StringBuilder::new,
                       StringBuilder::appendCodePoint,
                       StringBuilder::append)
              .toString()
        );

        return sb.toString();
    }

    public boolean reorderedPowerOf2(int n) {
        String str = sortedStr(n);

        for (int p = 0; p <= 29; p++) {
            if (str.equals(sortedStr(1 << p))) {
                return true;
            }
        }
        return false;
    }
}
