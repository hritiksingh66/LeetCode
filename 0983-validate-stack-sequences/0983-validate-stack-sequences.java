class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped){
        int m = pushed.length;

        int i = 0 , j = 0;

        Stack<Integer> st = new Stack<>();

        while(i<m && j<m){

            st.push(pushed[i]);

            while(!st.isEmpty() && popped[j]==st.peek() && j<m){
                st.pop();
                j++;
            }
            
            i++;
        }

        return st.isEmpty();
        
    }
}