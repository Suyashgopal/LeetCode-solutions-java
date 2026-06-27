class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1){
            return 1;
        }
        
        int [][] dp= new int[m][n];
        for(int[] k: dp){
            Arrays.fill(k, -1);

        }
        for(int i=0; i<m; i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        return fun(m-1, n-1, dp);


        
    }
    int fun(int r, int c, int [][] dp){
        if(r==0 && c==0){
            return 0;
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        dp[r][c]= fun(r-1, c, dp) + fun(r, c-1, dp);
        return dp[r][c];
    }
}