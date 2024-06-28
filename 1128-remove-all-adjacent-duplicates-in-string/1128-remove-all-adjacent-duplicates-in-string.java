class Solution {
    public String removeDuplicates(String s){
        
        Stack<Character> st = new Stack<>();

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek()==ch){
                st.pop();
                continue;
            }
            st.push(ch);
        }

        String ans = "";

        while(!st.isEmpty()){
            ans=ans+st.pop();
        }

        StringBuilder sb = new StringBuilder(ans);

        sb.reverse();

        return sb.toString();
    }
}