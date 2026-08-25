class Solution {
    public int[] countBits(int n) {
        int[] res= new int[n+1];
         res[0]=0;
        if(n==0){
           
            return res;
        }
        for(int i=1;i<=n;i++){
           int id= i& (i-1);
           res[i]= res[id]+1; 
        }
        return res;
        
    }
}