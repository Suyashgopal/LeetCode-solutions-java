class Solution {
    public int trap(int[] arr) {
        int n= arr.length;
        Stack<Integer> st= new Stack<>();
        int[] left= new int[n];
        int[] right= new int[n];

        int i=0;
        while(i<n){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i]=-1;
                st.push(arr[i]);
            }
            else{
                left[i]= st.peek();

            }
            i++;
        }

        st.clear();
        i=n-1;

        while(i>=0){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i]=-1;
                st.push(arr[i]);
            }
            else{
                right[i]= st.peek();

            }
            i--;
        }

        int res=0;
        for(i=0;i<n;i++){
            if(left[i]==-1 || right[i]==-1){continue;}

            int min= Math.min(left[i], right[i]);
            res= res+ min-arr[i];
        }
return res;




        
    }
}