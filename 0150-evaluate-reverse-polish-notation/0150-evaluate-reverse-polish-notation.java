class Solution {
    public int evalRPN(String[] arr) {
        //asuming that this -11 wont happen
        int n= arr.length;
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<n;i++){

           String s= arr[i];
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                st.push(Integer.parseInt(s));} 
                else {
                    int b = st.pop();
                    int a = st.pop();
                    st.push(calc(a, b, s));
                    }
        }
                 
                 return st.pop();
                 }

    int calc(int a, int b, String s) {
        if (s.equals("+")) {
            return a + b;
        } else if (s.equals("-")){
            return a - b;
        } else if(s.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }
}
