class Solution {
    public int minPathSum(int[][] mat) {
        int m= mat.length;
        int n= mat[0].length;
        int[][] dp= new int[m][n];
        for(int[] k: dp){
            Arrays.fill(k, -1);

        }

   

      return  fun(m-1,n-1, mat, dp);

        
    }
    int fun(int r, int c, int[][] mat, int[][] dp){
        if(r< 0 || c<0){
            return Integer.MAX_VALUE;

        }
        if(r==0 && c==0){
            return mat[0][0];
        }
        if(dp[r][c]!= -1){
            return dp[r][c];
        }
        
    

        int left= fun(r, c-1, mat,dp);
        int up= fun(r-1, c,mat, dp) ;
      
        dp[r][c]= mat[r][c]+ Math.min(left, up);
        return dp[r][c];
    }
}