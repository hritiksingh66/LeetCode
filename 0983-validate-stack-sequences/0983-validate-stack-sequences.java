class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped){
        int m = pushed.length;
        int n = popped.length;

        int i = 0;
        int j = 0;

        Stack<Integer> st = new Stack<>();

        while(i<m && j<n){

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