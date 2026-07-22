class Solution {
    public int[] xorQueries(int[] arr, int[][] mat) {
        
        int resn= mat.length;
        int[] res= new int[resn];

        //making xor array

        int n= arr.length;

        int[] xor= new int[n];
        xor[0]= arr[0];

        for(int i=1;i<n;i++){
            xor[i]= xor[i-1]^ arr[i];
        }

        for(int i=0;i< resn;i++){
            int st= mat[i][0];
            int end= mat[i][1];

        if( st ==0){
        
            res[i]= xor[end];
        }
        else{
            res[i]= xor[st-1] ^ xor[end];
        }
        }

return res;



        





    }
}