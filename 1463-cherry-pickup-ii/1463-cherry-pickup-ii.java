class Solution {
    public int cherryPickup(int[][] mat) {
        int r= mat.length;
        int c= mat[0].length;
        int [][][] dp= new int[r][c][c];
        for(int[][] m : dp){
            for(int [] k: m){
                Arrays.fill(k, -1);
            }
        }

 return   fun(0, 0, c-1,mat, dp);
        
    }
    int fun(int i, int j1, int j2, int [][] mat, int [][][] dp){
        int r= mat.length;
        int c= mat[0].length;
        
        if(j1<0 || j1>= c || j2<0 || j2>= c || i>=r ){
            return(int) -1e9;
        }
        if( dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }
        if(i==r-1){
         if(j1==j2){
          return mat[i][j1];
         }
         else {
            return mat[i][j1]+ mat[i][j2];
         }
        }

        int max=0;
        for(int dj1= -1 ; dj1<=1 ; dj1 ++){
            for (int  dj2 =-1 ; dj2<=1 ; dj2++){
              if(j1== j2){
             int a=  mat[i][j1]+ fun(i+1, j1+dj1, j2+ dj2,mat, dp);
               max= Math.max(max,a ) ;
              }
              else{
                int b= mat[i][j1]+ mat[i][j2] + fun(i+1, j1+dj1, j2+ dj2,mat, dp);
                max = Math.max(max, b);
              }
            }
        }
        dp[i][j1][j2]= max;
        return dp[i][j1][j2];




    }
}