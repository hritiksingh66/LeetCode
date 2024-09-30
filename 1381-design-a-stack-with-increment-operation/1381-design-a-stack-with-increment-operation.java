class CustomStack {
    int size=0;
    int array[];
    public CustomStack(int maxSize) {
         array=new int[maxSize];
    }
    
    public void push(int x) {
        if(size<array.length){
            array[size]=x;
            size++;
        }     
    }
    
    public int pop() {
        int element=-1;
        if(size>0){
            size--;
            element=array[size];  
        }
        return element;
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<size&&i<k;i++){
            array[i]=array[i]+val;
        } 
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */