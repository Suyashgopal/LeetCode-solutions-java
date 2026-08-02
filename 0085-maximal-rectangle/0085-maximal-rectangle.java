class Solution {
    public int maximalRectangle(char[][] mat) {

        int r= mat.length;
        int c= mat[0].length;
       
       int[]arr= new int[c];

         for(int i=0;i<c;i++){
            arr[i]= mat[0][i]-'0'; 
        }

        int res= largestRectangleArea(arr);

        for(int i=1;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]=='0'){
                    arr[j]=0;
                }
                else{
                    arr[j]= arr[j]+1;
                }
            }
            int max= largestRectangleArea(arr);
            res= Math.max(res, max);
        }
        return res;
        
    }




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