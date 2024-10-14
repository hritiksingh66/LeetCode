class Solution {
    public int firstUniqChar(String s){

        int ans = Integer.MAX_VALUE;

        for(int i = 0 ; i < s.length() ; i++){

            char ch = s.charAt(i);

            if(s.indexOf(ch) == s.lastIndexOf(ch)){
                return i;
            }
        }

        return -1;
    }
}