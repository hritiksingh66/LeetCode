// Company Asked :- AMAZON
class Solution{

    int[] getNSL(int[] arr , int n){
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }


    int[] getNSR(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return result;
    }


    public int sumSubarrayMins(int[] arr){

        int n = arr.length;
        int[] NSL = getNSL(arr,n);
        int[] NSR = getNSR(arr,n);

        // System.out.println(Arrays.toString(NSL));
        // System.out.println(Arrays.toString(NSR));

        long sum = 0;

        int M = 1_000_000_007;

        for(int i = 0; i < n; i++){
            long ls = i - NSL[i]; // left me kitne elements honge
            long rs = NSR[i]-i;  //  Right me kitne elements honge

            long totalWays = ls*rs;

            // totalSubways number subarray honge jiska min arr[i] hoga hmara

            long totalSum = arr[i] * totalWays;
            
            sum = (sum + totalSum) % M;

        }

        return (int)sum;    
    }
}