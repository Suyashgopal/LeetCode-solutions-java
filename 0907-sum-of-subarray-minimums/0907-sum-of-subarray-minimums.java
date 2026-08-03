class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n= arr.length;
        Stack <Integer> st= new Stack<>();
        int[] left= new int[n];
        int[] right= new int[n];

        int mod= (int) 1e9 +7;
        int i= 0;


        while(i<n){
            while(!st.isEmpty() &&  arr[st.peek()]> arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i]= i+1;
                st.push(i);
            }
            else{
                left[i]= i- st.peek();
                st.push(i);
            }
            i++;
        }

        st.clear();
        i=n-1;
        
          while(i>=0){
            while(!st.isEmpty() &&  arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i]= n-i;
                st.push(i);
            }
            else{
                right[i]=  st.peek()-i;
                st.push(i);
            }
            i--;
        }
     long sum=0;
     for( i=0; i<n ;i++){
        long curr= (1L * arr[i]* left[i]* right[i] );
       sum= (sum+ curr)% mod;

     }

     return (int) sum;





    
        
    }
}