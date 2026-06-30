class Solution {
    public int change(int amount ,int[] coins) {
        int n= coins.length;
 int[][] dp = new int[n][amount+1];
       for(int[] k: dp){
        Arrays.fill(k, -1);
       }
        
       int res=  fun(n-1, amount, coins, dp);
      
    
       return res;

        
    }

    int fun(int idx,int t, int[]arr, int[][] dp){
   if(idx==0){
     int div= t/arr[0];
     t= t- div*arr[0];
     if(t==0){
        return 1;
     }
     return 0;
   }
   if(dp[idx][t]!= -1){
    return dp[idx][t];
   }
   int take =0;
   if(arr[idx]<=t){
     take=  fun(idx, t-arr[idx], arr, dp);
   }
   int nottake= fun(idx-1, t, arr, dp);
   dp[idx][t]= take + nottake;
 return dp[idx][t];
    }
}