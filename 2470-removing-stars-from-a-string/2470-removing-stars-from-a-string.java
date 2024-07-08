class Solution {
    public String removeStars(String s){

        int n = s.length();

        char[] temp = new char[n];
        int j = 0;
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                j--;
            }else{
                temp[j] = ch;
                j++;
            }
        }

        String ans = "";
        int k = 0;

        while(k <= (j-1)){

            ans += temp[k];
            k++;
        }


        return ans;
    }
}