class Solution {
    public int maxProfit(int[] arr) {
        int n= arr.length;

        int[][][] dp= new int[n][2][2];
        for(int[][] k: dp){
            for(int [] l : k){
                Arrays.fill(l, -1);
            }
        }
       
        return fun(0, 1, arr, 0,dp);
        
    }
    int fun(int id,int buy, int[] arr,int t, int[][][] dp ){
        if(id==arr.length || t==2 ){
         return 0;
        }
        if(dp[id][buy][t]!=-1){
            return dp[id][buy][t];
        }
        int pbuy=0;
        int psell=0;
        if(buy==1 ){
            
            int a= -arr[id]+ fun(id+1, 0,arr,t,dp);
          pbuy= Math.max( a, fun(id+1, 1,arr, t,dp)    ) ; 
        }

        if(buy==0 && t<2){
            int b=arr[id]+ fun(id+1, 1,arr,t+1, dp);
          psell= Math.max( b, fun(id+1, 0,arr, t,dp)) ; 
        }
        dp[id][buy][t]= Math.max(pbuy, psell);
        return dp[id][buy][t];

    }
}