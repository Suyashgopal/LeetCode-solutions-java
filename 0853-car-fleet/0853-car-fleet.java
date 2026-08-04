class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n= speed.length;

        int[][] mat= new int[n][2];
        for(int i=0;i<n;i++){
            mat[i][0]= position[i];
            mat[i][1]= speed[i];
        }

        Arrays.sort(mat, (a,b)-> b[0]-a[0]);
        Stack<Double> st= new Stack<>();
        for(int i=0;i<n;i++){
            double time= (double)(target- mat[i][0])/mat[i][1];
         if(st.isEmpty()|| time>st.peek()){
            st.push(time);
         }

        } 
return st.size();
        
    }
}