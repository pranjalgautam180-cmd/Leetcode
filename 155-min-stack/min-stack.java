class MinStack {

    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MIN_VALUE;
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            min = value;
            st.push((long)value);
        }
        else{
            if(value > min){
                st.push((long)value);
            }
            else{
                st.push(2L * value - min); //encoded value
                min = value; // min wali value
            }
        }
    }
    
    public void pop() {  // remove and restore
        if(st.isEmpty()){
            return;
        }
        long x = st.peek();
        st.pop();
        if(x < min){
            min = (2 * min - x);
        }
    }
    
    public int top() {  // read and decode
        if(st.isEmpty()){
            return -1;
        }

        long x = st.peek();

        if(x < min){
            return (int) min;
        }
        return (int) x;
    }
    
    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */