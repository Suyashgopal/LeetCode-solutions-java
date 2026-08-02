class StockSpanner {
    Stack<Integer> st;
    ArrayList<Integer> al;
    int id;

    public StockSpanner() {
        st= new Stack<>();
        al= new ArrayList<>();
        id=-1;


    }
    
    public int next(int price) {
        id++;
        al.add(price);

        while(!st.isEmpty() && al.get(st.peek())<= price ) {
            st.pop();
        }
        if(st.isEmpty()){
            st.push(id);
            return id+1;
        }
        else{
            int k= st.peek();
            st.push(id);
            return id-k;

        }




        
    }

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */