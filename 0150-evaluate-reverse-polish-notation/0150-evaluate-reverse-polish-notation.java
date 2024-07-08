class Solution {
   private static final Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
    static {
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> a / b);
    }

   public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = st.pop();
                int a = st.pop();
                int result = operations.get(token).apply(a, b);
                st.push(result);
            } else {
                st.push(Integer.valueOf(token));
            }
        }
        return st.pop();
    }
}