// Company Asked :- AMAZON
import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        
        // Fill left array
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear(); // Clear the stack to reuse it
        
        // Fill right array
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        int sum = 0;
        int M = 1_000_000_007;
        
        for (int i = 0; i < n; i++) {
            int ls = i - left[i]; // Number of elements to the left
            int rs = right[i] - i; // Number of elements to the right
            int totalWays = ls * rs; // Total number of subarrays where arr[i] is the minimum
            long totalSum = (long) arr[i] * totalWays; // Sum contributed by arr[i]
            sum = (int) ((sum + totalSum) % M);
        }
        
        return sum;
    }
}
