class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int i = 1;
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        while (i < n) {
           
           if(arr[i]<st.peek()){
            int max= st.pop();
            while(!st.isEmpty() && st.peek()> arr[i]){
                st.pop();
            }
            st.push(max);
           }

            else{
               
                st.push(arr[i]);
            }


            i++;
        }
        return st.size();

    }
}