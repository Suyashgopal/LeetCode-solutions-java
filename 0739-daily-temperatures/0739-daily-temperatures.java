class Solution {
    public int[] dailyTemperatures(int[] arr) {
    int n= arr.length;
    int[] res= new int[n];
    int i= n-1;
    Stack<Integer> st= new Stack<>();

    while(i>=0){
        while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
            st.pop();
        }

        if(st.isEmpty()){
            res[i]=0;
            
        }
        else{
            res[i]= st.peek()-i;
            
        }
        st.push(i);
        i--;

    }

    return res;



        
    }
}