class MinStack {
     Stack<Integer> st;
      Stack<Integer> min;
      int mini;



    public MinStack() {
       st= new Stack<>();
       min= new Stack<>();
    
        
    }
    
    public void push(int value) {
        st.push(value);

        if(min.isEmpty()){
            min.push(value);
        }
        else{
            int k= min.peek();
            if(value<=k){
                min.push(value);
            }
        }



        
        
    }
    
    public void pop() {
      int k=  st.pop();

      if(!min.isEmpty() && min.peek()== k){
        min.pop();
      }

        
    }
    
    public int top() {
        int k= st.peek();
        return k;
        
    }
    
    public int getMin() {
        return min.peek();
        
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