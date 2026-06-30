class Solution {
    public int coinChange(int[] arr, int t) {
        int n= arr.length;
        int[][] dp= new int[n][t+1];

    for(int[] k: dp){
        Arrays.fill(k, (int)1e9);
    }
   
   for(int i=0;i<=t;i++){
    if(i%arr[0]==0){
        dp[0][i]= i/arr[0];
            }
   }

   for(int i=1;i<n;i++){
    for(int tar=0;tar<=t;tar++){
        int take = (int)1e9;
        if(arr[i]<=tar){
            take = 1+ dp[i][tar-arr[i]];
        }
        int nottake= dp[i-1][tar];
        dp[i][tar]= Math.min(take, nottake);
    }
   }
   if (dp[n-1][t]==1e9){return -1;}
   return dp[n-1][t];

        
        


        
    }
}