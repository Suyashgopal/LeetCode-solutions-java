class Solution {
    public int maxProfit(int[] arr) {
        int n= arr.length;

        int[][][] dp= new int[n+1][2][3];
        for(int[][] k: dp){
            for(int [] l : k){
                Arrays.fill(l,0);
            }
        }


   for(int id= n-1; id>=0;id--){
    for(int buy=0;buy<=1;buy++){
        for(int t=0;t<2;t++){



        int pbuy=0;
        int psell=0;
        if(buy==1 ){
          int a= -arr[id]+ dp[id+1][0][t];
          pbuy= Math.max( a,  dp[id+1][1][t]    ) ; 
        }

        if(buy==0 && t<2){  
        int b=arr[id]+  dp[id+1][1][t+1] ;
        psell= Math.max( b,dp[id+1][0][t] ) ; 
        }
         dp[id][buy][t]= Math.max(pbuy, psell);

        }
    }
   }

       
        return dp[0][1][0];
        
    }
   
    
}