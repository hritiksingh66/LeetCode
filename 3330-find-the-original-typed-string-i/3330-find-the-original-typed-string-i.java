class Solution {
    public int possibleStringCount(String word){
        int noOfRepeatedChar = 0;
        for(int i = 1; i < word.length();i++){
            if(word.charAt(i)== word.charAt(i-1)){
                noOfRepeatedChar++;
            }
        }
        return noOfRepeatedChar + 1;
    }
}