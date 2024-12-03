public class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int prevIndex = 0;

        for (int space : spaces) {
            result.append(s, prevIndex, space).append(' '); // Append substring and space
            prevIndex = space;
        }
        result.append(s.substring(prevIndex)); // Append remaining part of the string
        
        return result.toString();
    }
}
