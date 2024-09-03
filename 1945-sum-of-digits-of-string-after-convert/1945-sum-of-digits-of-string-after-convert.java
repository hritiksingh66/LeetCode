class Solution {


    public int getLucky(String s, int k) {

        // String ke saare characters ko uske corresponding numeric value me convert karenge 
        StringBuilder number = new StringBuilder();
        for (char x : s.toCharArray()) {
            number.append(x - 'a' + 1);
        }

        while (k > 0) {
            int temp = 0;
            for (char x : number.toString().toCharArray()) {
                temp += x - '0';  // current number ka digits ko sum karenge
            }
            number = new StringBuilder(String.valueOf(temp));  // int sum ko wapas string me convert karenge
            k--;
        }

        return Integer.parseInt(number.toString());  //final result return karenge
    }
}