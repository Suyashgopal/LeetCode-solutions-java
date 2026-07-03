class Solution {
    public int maxProfit(int[] arr) {
        int n= arr.length;

        int[][][] dp= new int[n+1][2][3];
        for(int[][] k: dp){
            for(int [] l : k){
                Arrays.fill(l,0);
            }
        }
        int[][] ahead= new int[2][3];
        
   for(int id= n-1; id>=0;id--){
 int[][] curr= new int[2][3];
 for(int t=0;t<2;t++){
       curr[1][t]= Math.max( (-arr[id]+ ahead[0][t]), ahead[1][t]);
       curr[0][t]= Math.max((arr[id]+ ahead[1][t+1]), ahead[0][t]);
 }
 ahead= curr;
   }

       return ahead[1][0];
        
    }
   
    
}