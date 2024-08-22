class Solution {
    public static String toBinaryString(int number) {
        if (number == 0) {
            return "0";
        }
        
        StringBuilder binaryString = new StringBuilder();
        while (number > 0) {
            binaryString.insert(0, number % 2);
            number = number / 2;
        }
        return binaryString.toString();
    }
    public int findComplement(int num){
        String s = toBinaryString(num);

        int n = s.length();
        int temp = (int)Math.pow(2,n) - 1;


        return temp - num;
    }
}