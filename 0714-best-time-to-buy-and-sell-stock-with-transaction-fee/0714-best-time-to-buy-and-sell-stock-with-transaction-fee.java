class Solution {
    public int maxProfit(int[] arr, int fee) {
        int n= arr.length;


       int[][] dp = new int[n][2];
       for(int [] k: dp){
        Arrays.fill(k, -1);
       }
       return fun(0, 1, arr, dp,fee);
        
    }
    
    int fun(int id,int buy, int[] arr, int[][] dp, int fees ){
        if(id>=arr.length){return 0;}
        int pbuy=0;
        int psell=0;

        if(dp[id][buy]!= -1){
         return dp[id][buy];
        }

        if(buy==1){
            int a= -arr[id]+ fun(id+1, 0, arr, dp, fees);
            pbuy = Math.max(fun(id+1, 1, arr, dp, fees), a);

        }
        if(buy==0){
            int a= arr[id]- fees+ fun(id+1, 1,arr, dp, fees);
            psell= Math.max(fun(id+1,0, arr,dp, fees), a);
        }
       dp[id][buy]= Math.max(pbuy, psell);
       return dp[id][buy];
    }


}



