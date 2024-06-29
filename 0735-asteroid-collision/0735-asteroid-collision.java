class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer>st = new Stack<>();
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] > 0)
            {
                st.push(arr[i]);
            }
            else
            {
                //jab tak explode hote ja rha hh karte raho
                while(!st.isEmpty() && st.peek() > 0 && st.peek() <  Math.abs(arr[i]))
                {
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == Math.abs(arr[i]))
                {
                    st.pop();
                }
                else if(!st.isEmpty() && st.peek() > Math.abs(arr[i]))
                {
                    continue;
                }
                else
                {
                    st.push(arr[i]);
                }

            }
        }
        
        int[] ans = new int[st.size()];
        for(int i=st.size() - 1; i>=0; i--)
        {
            ans[i] = st.pop();
        }
        return ans;
    }
}