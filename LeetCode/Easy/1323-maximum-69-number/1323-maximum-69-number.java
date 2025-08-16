class Solution {
    public int maximum69Number (int num){

        char[] numArray = String.valueOf(num).toCharArray();

        for(int i = 0 ; i < numArray.length ; i++){
            char digit = numArray[i];
            if(digit == '6'){
                numArray[i] = '9';
                break;
            }
        }

        String str = String.valueOf(numArray);

        return Integer.parseInt(str);
    }
}