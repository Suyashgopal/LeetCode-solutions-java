class Solution {
    public int maxProfit(int[] arr) {
        int n= arr.length;
        int[][] dp = new int[n+1][2];
        for(int[] k: dp){
            Arrays.fill(k, 0);
        }
        
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){


                if(j==1){
            int a = -arr[i]+ dp[i+1][0] ;
            int b= dp[i+1][1];
            dp[i][1]= Math.max(a,b); 
        }

         if(j==0){
            int a= arr[i]+ dp[i+1][1];
            int b= dp[i+1][0];
            dp[i][0]= Math.max(a,b);
        }


            }
        }

 return dp[0][1];






        
    }
   
}