// MONOTIC STACK AS BOTTOM TO UP , ALL THE NUMBERS ARE STORED IN ASCENDING ORDER
class StockSpanner {
    Stack<Pair<Integer, Integer>> st;
    public StockSpanner(){
         st = new Stack<>();
    }
    
    public int next(int price){
        int span = 1; // Initially, the span of the current price is 1 (itself)

        // Calculate span for previous days with prices less than or equal to current price
        while (!st.isEmpty() && st.peek().getKey() <= price) {
            span += st.pop().getValue();
        }

        // Push the current price and its calculated span onto the stack
        st.push(new Pair<>(price, span));

        return span;
    }

    // Helper Pair class to store price and span
    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */