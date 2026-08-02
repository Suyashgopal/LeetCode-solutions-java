class Solution {
    public int largestRectangleArea(int[] arr) {
        int n= arr.length;
        Stack<Integer> st= new Stack<>();
        int[] right= new int[n];
        int i= n-1;
        while(i>=0){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i]= n- i;
                st.push(i);
            }
            else{
                
                right[i]= st.peek()-i;
                 st.push(i);
            }
         i--;

        }
        st.clear();
        i=0;
        int[] left= new int[n];
        while(i<n){
                   while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i]= i;
                st.push(i);
            }
            else{
                left[i]= i- st.peek()-1;
                 st.push(i);
            }
          i++;

        }
        int max=0;

        for( i=0;i<n;i++){
            int area= (left[i]+ right[i])* arr[i];
            max= Math.max(max, area);
        }
        return max;


        
    }
}