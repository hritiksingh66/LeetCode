class Solution {
    public String convertToTitle(int columnNumber){
        String res = "";

        while(columnNumber > 0){
            columnNumber--; // for handling corner case like 26 ke case me remainder 0 aane pe ASCII 65 chali jayegi
            int remainder = columnNumber % 26;
            res += (char)(remainder + 'A');

            columnNumber/= 26;
        }

        StringBuilder sb = new StringBuilder(res);
        sb.reverse();
        return sb.toString();
    }
}