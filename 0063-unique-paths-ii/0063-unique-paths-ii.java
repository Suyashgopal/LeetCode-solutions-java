class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {
        int m= mat.length;
        int n= mat[0].length;
        if(mat[0][0]==1 || mat[m-1][n-1]==1){return 0;}
       
        if(m==1 && n==1){
            if(mat[0][0]==1){return 0;
            }
            return 1;
        }
       
        int[][] dp= new int [m][n];
         for(int[] k: dp){
            Arrays.fill(k,-1);

         }
       
       

        
        return fun(m-1, n-1, dp, mat);
    }
    int fun(int r, int c, int[][] dp, int [][] mat){
        if(r < 0 || c < 0) return 0;

    if(mat[r][c] == 1) return 0;

    if(r == 0 && c == 0) return 1;

    if(dp[r][c] != -1) return dp[r][c];

    return dp[r][c] = fun(r-1, c, dp, mat)
                    + fun(r, c-1, dp, mat);}

}