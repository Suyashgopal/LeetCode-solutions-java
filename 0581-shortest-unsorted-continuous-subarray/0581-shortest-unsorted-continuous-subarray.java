class Solution {
    public int findUnsortedSubarray(int[] arr) {
        int n= arr.length;
        Stack<Integer> st= new Stack<>();
        int left= n;
        int right=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                left= Math.min(left, st.pop());
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]>arr[st.peek()]){
                right= Math.max(right, st.pop());
            }
            st.push(i);
        }

        if(right<left){return 0;}
        return right-left+1;

        
    }
}