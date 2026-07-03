class Solution {
    public int maxProfit(int k, int[] arr) {
        int n= arr.length;

        int[][][] dp= new int[n][2][k+1];
        for(int[][] h: dp){
            for(int[] l: h){
             Arrays.fill(l, -1);
            }
        }
        return fun(0,1,k, arr, dp);
        
    }
    int fun(int id,int buy, int t, int[] arr, int[][][]dp){
        if(t==0|| id==arr.length){
            return 0;
        }
        if(dp[id][buy][t]!=-1){
            return dp[id][buy][t];

        }
        int pbuy=0;
        int psell=0;

        if(buy==1){
      pbuy= Math.max((-arr[id]+ fun(id+1, 0, t, arr, dp)),   fun(id+1, 1, t,arr, dp));
        }
        if(buy==0 && t>0){
       psell= Math.max((arr[id]+ fun(id+1, 1, t-1, arr, dp)), fun(id+1, 0, t, arr, dp));
        }
        dp[id][buy][t]= Math.max(pbuy, psell);
         return dp[id][buy][t];
    }
}