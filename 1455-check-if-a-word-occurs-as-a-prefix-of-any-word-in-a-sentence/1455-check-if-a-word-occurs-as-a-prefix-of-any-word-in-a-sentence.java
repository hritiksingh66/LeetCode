class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        if(!sentence.contains(searchWord)) return -1;

        String[] str = sentence.split(" ");
        int i = 0, n = str.length;
        while(i < n){
            if(str[i].indexOf(searchWord) == 0){
                return i + 1;
            }
            i += 1;
        }
        return -1;
    }
}