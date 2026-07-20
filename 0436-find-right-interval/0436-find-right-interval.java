class Solution {
    public int[] findRightInterval(int[][] mat) {
        //make a mat of st- orignal idx
        int n= mat.length;

        int[][] st= new int[n][2] ;

        for(int i=0;i<n;i++){
            st[i][0]= mat[i][0];
            st[i][1]= i;
        }
        Arrays.sort(st, (a, b)-> Integer.compare(a[0], b[0]));

        int[] res= new int[n];
        for(int i=0;i<n;i++){
            int id= bs(mat[i][1], st);
            res[i]= id;
        }


     return res;
        
    }
    int bs(int t, int[][] st ){
        int n= st.length;
        int low= 0;
        int high=  n-1;

        while(low<high){
            int mid= low+(high-low)/2;

            if(st[mid][0]>=t){
                high= mid;
            }
            else{
                low= mid+1;
            }


        }
        if(st[low][0]<t){return -1;}

        return st[low][1];

    
    }
}