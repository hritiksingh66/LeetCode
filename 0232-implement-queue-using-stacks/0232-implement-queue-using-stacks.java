class MyQueue{

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    int peekEl = -1;

    public MyQueue(){

        
    }
    
    public void push(int x){

        if(input.isEmpty()){
            peekEl = x;
        }
        input.push(x); // ye kaam har baar karna  hai 
    }
    
    // Amortized o(1) means mostly takes O(1) and sometimes O(n)
    public int pop(){
        if(output.isEmpty()){
            // Input --> OutPut O(n)
            while(input.size()>0){
                output.push(input.pop());
            }
        }
        int val = output.peek(); // O(1) in most cases
        output.pop();
        return val;
    }
    
    public int peek(){
        if(!output.isEmpty()){
            return output.peek();
        }
        
        return peekEl;
    }
    
    public boolean empty(){
        if(output.isEmpty() && input.isEmpty()){
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */