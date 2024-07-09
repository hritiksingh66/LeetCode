class Solution {
    public String removeKdigits(String num, int k){
        int n = num.length();

        String result = "";

        for(int i = 0 ; i < n ; i++){

            while(result.length()>0 && (result.charAt(result.length() - 1)-'0') > (num.charAt(i)-'0') && k>0){
                result = result.substring(0, result.length() - 1);
                k--;
            }

            if(result.length()>0 || num.charAt(i)!='0'){
                result = result + num.charAt(i);
            }
        }


        while(k>0 && result.length()>0){
            result = result.substring(0, result.length() - 1);
            k--;
        }


        if(result.length()==0){
            return "0";
        }

        return result;
    }
}