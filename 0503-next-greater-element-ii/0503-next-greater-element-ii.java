class Solution {
    public int[] nextGreaterElements(int[] arr){
        Stack<Integer> st = new Stack<>();
        int []res = new int[arr.length];
        Arrays.fill(res,-1);
        int n = arr.length;
        for(int i = 0; i<2*n;i++){
            while(!st.isEmpty() && arr[i%n]>arr[st.peek()]){
                res[st.pop()] = arr[i%n];
            }
            st.push(i%n);
        }
        return res;
    }
}