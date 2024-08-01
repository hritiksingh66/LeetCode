class Solution {
    public int countSeniors(String[] details){
        int n = details.length;
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            if((details[i].charAt(11))-'0'> 6){
                result++;
            }
            if((details[i].charAt(11))-'0'== 6 && (details[i].charAt(12))-'0' != 0){
                result++;
            }
        }
        return result;
    }
}