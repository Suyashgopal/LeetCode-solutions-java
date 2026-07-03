class Solution {
    public int maxProfit(int k, int[] arr) {
        int n= arr.length;

        int[][][] dp= new int[n+1][2][k+1];
      

        for(int id= n-1;id>=0;id--){
            for(int buy=0; buy<2; buy++){
                for(int t=k-1 ;t>=0;t--){
                    int pbuy=0;
                    int psell=0;

                    if(buy==1){
                     pbuy= Math.max((-arr[id]+ dp[id+1][0][t]) , dp[id+1][1][t]  );
                    }
                    else{
                        psell= Math.max((arr[id]+ dp[id+1][1][t+1]), dp[id+1][0][t]);
                    }
                    dp[id][buy][t]= Math.max(pbuy, psell);
                }
            }


        }






        return dp[0][1][0];
        
    }
}