class Solution {
    public String countAndSay(int n){
        if(n <= 0) return "";

        String res = "1";

        for(int i = 1 ; i < n ; i++){
            res = solve(res);
        }

        return res;
    }

    public String solve(String s){
        StringBuilder sb = new StringBuilder();

        int count = 1;

        char prev = s.charAt(0);

        for(int i = 1; i < s.length() ; i++){
            if(prev == s.charAt(i)){
                count++;
            }else{
                sb.append(count).append(prev);
                prev = s.charAt(i);
                count = 1;
            }
        }

        sb.append(count).append(prev);

        return sb.toString();
    }
}