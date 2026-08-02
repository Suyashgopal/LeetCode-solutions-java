class Solution {
    public int[] nextGreaterElements(int[] arr) {
    //2 nge to left and nge to right
    int n  = arr.length;

    int[] res= new int[n];
    Stack<Integer> st= new Stack<>();

    

     int  i=n-1;

      while(i>=0){
        while(!st.isEmpty() && st.peek()<=arr[i]){
            st.pop();
        }
        st.push(arr[i]);
            i--;

    }
     i=n-1;
 
       while(i>=0){
        while(!st.isEmpty() && st.peek()<=arr[i]){
            st.pop();
        }
        if(st.isEmpty()){
            res[i]= -1;
            st.push(arr[i]);
        }
        else{
            res[i]= st.peek();
            st.push(arr[i]);
        }
        i--;

    }


return res;


    }
}