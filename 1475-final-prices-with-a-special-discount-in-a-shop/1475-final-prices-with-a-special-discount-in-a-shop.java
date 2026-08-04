class Solution {
    public int[] finalPrices(int[] arr) {
        int n= arr.length;
        Stack<Integer> st= new Stack<>();
        int i= n-1;
        int[] res= new int[n];
        while(i>=0){
            while(!st.isEmpty() && st.peek()>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                st.push(arr[i]);
                res[i]= arr[i];
            }
            else{
                res[i]= arr[i]- st.peek();
                st.push(arr[i]);
            }
            i--;
        }
        return res;

    
        
    }
}