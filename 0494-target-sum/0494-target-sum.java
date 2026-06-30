class Solution {
    public int findTargetSumWays(int[] arr, int t) {
        int n= arr.length;
        int sum=0;
       

        for(int i=0;i<n;i++){
            sum= sum+ arr[i];
        }
         if (sum < Math.abs(t)) return 0;
        if ((sum - t) % 2 != 0) return 0;


         t= (sum-t)/2;





         int[][] dp= new int[n][t+1];
         for(int[] k: dp){
            Arrays.fill(k, -1);
         }
      
       return fun(n-1,t,arr, dp);
    }
    int fun(int idx, int t, int[] arr, int [][] dp){
        if(idx==0){
            if(t==0){
                if(arr[idx]==0){return dp[idx][t]=2;}
                return dp[idx][t]= 1;
            }
            if(t==arr[0]){
                return dp[idx][t] =1;
            }
            return dp[idx][t]= 0;
        }
        if(dp[idx][t]!=-1){
            return dp[idx][t];
        }

      int sub=0;
        if(arr[idx]<=t){
         sub= fun(idx-1,t-arr[idx], arr ,dp );
        }
        int notsub= fun(idx-1, t, arr,dp);
         dp[idx][t]= sub + notsub;
         return dp[idx][t];
    }
}