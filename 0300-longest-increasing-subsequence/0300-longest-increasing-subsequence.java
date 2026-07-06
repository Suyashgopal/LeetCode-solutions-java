class Solution {
    public int lengthOfLIS(int[] arr) {
        int n= arr.length;
        int[][] dp= new int[n +1][n+1];
        for(int id = n-1; id>=0 ; id--){
            for(int prev= 0; prev<=n  ; prev++){
               int skip= dp[id+1][prev];
               int pick=0;
       if(prev==0 || arr[id]> arr[prev-1]){
             pick= 1+dp[id+1][id+1];
        }
         dp[id][prev]= Math.max(pick, skip);
  
            }
        }
       
        return dp[0][0];

        
    }

}