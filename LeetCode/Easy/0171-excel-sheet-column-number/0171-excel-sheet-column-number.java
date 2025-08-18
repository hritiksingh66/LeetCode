class Solution {
    public int titleToNumber(String columnTitle){
        int res = 0;

        for(char ch : columnTitle.toCharArray()){
            int pos = ch-64;
            res = res * 26 + pos;
        }

        return res;
        
    }
}